package LAB6STR;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String args[]) {

        Semaphore s = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        CyclicBarrier bariera = new CyclicBarrier(2, new Runnable() {

            public void run() {
                System.out.println("Rutina barierei");
            }
        });
        Fir fir1 = new Fir(7,bariera,s,s2,4,1,1,2,4);
        Fir fir2 = new Fir(2,bariera,s,s2,5,1,1,3,5);
        Fir fir3 = new Fir(2,bariera,s,s2,5,1,1,3,5);
        fir1.start();
        fir2.start();
        fir3.start();
    }
}