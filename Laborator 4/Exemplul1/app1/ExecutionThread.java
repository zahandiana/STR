/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1.app1;

/**
 *
 * @author diana
 */
public class ExecutionThread extends Thread{
    Integer monitor;
   int activity_min,activity_max,sleep ;

    public ExecutionThread(Integer monitor, int activity_max, int activity_min, int sleep){
        this.monitor=monitor;
        this.activity_max=activity_max;
        this.activity_min=activity_min;
        this.sleep=sleep;
    }
    public void run(){
        System.out.println(this.getName() + " - STATE1" + " " + System.nanoTime());
        synchronized (monitor) {
            System.out.println(this.getName() + " - STATE2" + " " + System.nanoTime());
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 10000; i++) {
                i++;
                i--;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(this.getName() + " - STATE3" + " " + System.nanoTime());
            }
}
    }
}
