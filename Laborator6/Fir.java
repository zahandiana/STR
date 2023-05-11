package Laborator6;

import java.util.concurrent.BrokenBarrierException;
        import java.util.concurrent.CyclicBarrier;
class Fir extends Thread {
    CyclicBarrier bariera;
    public Fir(CyclicBarrier bariera) {
        this.bariera = bariera;
    }
    // se executacand am ajunge la bariera, atunci cat decrementarea ajunge la 0
    // se reia cand totul ajunge la 0
    public void run() {
            while (true) {
            activitate();
            try {
                // in timp c e astepata la bariera pot apatrea 2 tiputi de eroori : sparg bariera sau unul din fire asteapta
                // asteapta la bariera, decrementeza intregul din bariera pune firul in asteptare
                bariera.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
               e.printStackTrace();
            }
            activitate();
        }
    }
       public void activitate() {
        System.out.println(this.getName() + "> activitate");
        try {
            Thread.sleep(Math.round(Math.random() * 3 + 3) * 1000);
        } catch (InterruptedException e) {
        }
    }
}