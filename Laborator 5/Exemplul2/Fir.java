package Package1;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread{
    int nume;
    Lock l1;
    Lock l2;
    int sleep_min, sleep_max, activity_min, activity_max, sleepNumber;

    Fir(int n, Lock la1, Lock la2, int sleep_min, int sleep_max, int activity_min, int activity_max, int sleepNumber) {

        this.nume = n;
        this.l1 = la1;
        this.l2 = la2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleepNumber = sleepNumber;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        l1.lock();
        System.out.println("Fir " + nume + " a pus zavorul");
        System.out.println(this.getName() + " - STATE 2");
        if(l2.tryLock()){
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(this.sleepNumber);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.unlock();
            System.out.println("Fir " + nume + " a eliberat zavorul");
            l2.unlock();
            System.out.println("Fir " + nume + " a eliberat zavorul");
        }
        else{
            l1.unlock();
            System.out.println("Fir " + nume + " a eliberat zavorul");
            try {
                Thread.sleep(this.sleepNumber * 2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.lock();
            System.out.println("Fir " + nume + " a pus zavorul");
            l2.lock();
            System.out.println("Fir " + nume + " a pus zavorul");
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(this.sleepNumber);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.unlock();
            System.out.println("Fir " + nume + " a eliberat zavorul");
            l2.unlock();
            System.out.println("Fir " + nume + " a eliberat zavorul");

        }
        System.out.println(this.getName() + " - STATE 4");
    }
}