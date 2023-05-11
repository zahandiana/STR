package LAB6STR;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class Fir extends Thread {

    Semaphore s,s2;
    CyclicBarrier bariera;
    private int nume;
    private int sleep;
    private int k;
    private int permise;
    private int permise2;
    int activity_min, activity_max;

    Fir(int nume, CyclicBarrier bariera, Semaphore s, Semaphore s2, int sleep, int permise, int permise2, int activity_min, int activity_max) {

        this.nume = nume;
        this.bariera = bariera;
        this.s = s;
        this.s2=s2;
        this.sleep = sleep;
        this.permise = permise;
        this.permise2 = permise2;
        this.activity_min=activity_min;
        this.activity_max=activity_max;

    }

    public void run() {

        while (true) {
            activitate();
            try {
                bariera.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void activitate() {

        System.out.println(this.getName() + "> activitate");

        try {

            System.out.println(this.getName() + " - STATE 1");
            k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            this.s.acquire(this.permise);
            this.s2.acquire(this.permise);
            System.out.println("Fir " + nume + " a luat" + this.permise + " jetoane din semafor");

            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 3");
            this.s.release(this.permise2); // sfarsit regiune critica
            this.s2.release(this.permise2);

            System.out.println("Fir " + nume + " a eliberat" + this.permise2 + " jetoane din semafor");
            Thread.sleep(this.sleep * 500);
            System.out.println(this.getName() + " - STATE 4");
        } catch (InterruptedException e) {
        }
    }
}