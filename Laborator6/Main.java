package Laborator6;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class Main { public static void main(String args[]) {
        CyclicBarrier bariera = new CyclicBarrier(3, new Runnable() {
        public void run() {
            System.out.println("Rutina barierei");
        }
    }
    );
    Fir fir1 = new Fir(bariera);
    Fir fir2 = new Fir(bariera);
    Fir fir3 = new Fir(bariera);
    fir1.start();
    fir2.start();
    fir3.start();
}
}
