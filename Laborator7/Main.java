package Laborator7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) {
        Semaphore s = new Semaphore(2);
        Fir f1, f2, f3;
        f1 = new Fir(1, s, 5, 3, 6, 1, 1);
        f2 = new Fir(2, s, 3, 4, 7 , 1, 1);
        f3 = new Fir(3, s, 6, 5, 7,1, 1);
        f1.start();
        f2.start();
        f3.start();

    }
}