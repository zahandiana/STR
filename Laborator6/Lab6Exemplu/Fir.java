package Lab6Exemplu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;

public class Fir extends Thread{
    int nume, intarziere, activity_max, activity_min, permise, permise2;
    Semaphore s;
    CountDownLatch latch;

    Fir(int n, Semaphore sa, int intarziere, int activity_min, int activity_max, int permise, int permise2){

        this.nume = n;
        this.s = sa;
        this.intarziere = intarziere;
        this.activity_max = activity_max;
        this.activity_min = activity_min;
        this.permise = permise;
        this.permise2 = permise2;
        this.latch = latch;
    }

    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                this.s.acquire(this.permise); //face aq
                System.out.println("Fir " + nume + " a luat un jeton din semafor");
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s.release(this.permise2);
                System.out.println("Fir " + nume + " a eliberat un jeton din semafor");
                this.latch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(this.intarziere * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}