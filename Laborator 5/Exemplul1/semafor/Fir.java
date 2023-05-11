package Package.semafor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Fir extends Thread {
      int nume, intarziere, k, permise;
      Semaphore s;
    Fir(int n, Semaphore sa, int intarziere, int k, int permise) {

        this.nume = n;
        this.s = sa;
        this.intarziere = intarziere;
        this.k = k;
        this.permise = permise;
    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");

        while (true) {

            try {
                Thread.sleep(this.intarziere * 500);
                System.out.println(this.getName() + " - STATE 2");
                this.s.acquire(this.permise); // regiune critica
                System.out.println("Fir " + nume + " a luat un jeton din semafor");
                System.out.println(this.getName() + " - STATE 3");
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s.release(); // sfarsit regiune critica
                System.out.println("Fir " + nume + " a eliberat un jeton din semafor");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 4");
        }
    }
}

