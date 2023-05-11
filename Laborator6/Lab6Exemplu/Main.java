package Lab6Exemplu;
import java.util.concurrent.Semaphore;

    public class Main {
        public static void main(String[] args) {

            Semaphore s = new Semaphore(1, true);

            Fir f1 = new Fir(1, s, 7, 2, 3, 1, 1);
            Fir f2 = new Fir(2, s, 1, 3, 5, 1, 1);
            Fir f3 = new Fir(3, s, 1, 4, 6, 1, 1);

            f1.start();
            f2.start();
            f3.start();

        }
    }