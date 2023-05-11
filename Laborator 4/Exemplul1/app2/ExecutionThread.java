/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1.app2;

/**
 *
 * @author diana
 */
public class ExecutionThread extends Thread{
    Integer monitor1;
    Integer monitor2;
    int activity_min, activity_max, sleep;
 
 public ExecutionThread(Integer monitor1, Integer monitor2, int activity_min, int activity_max, int sleep){
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.activity_min=activity_min;
        this.activity_max=activity_max;
        this.sleep=sleep;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE1" + " " + System.nanoTime());
        int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++; i--;
        }
        synchronized (monitor1){
            synchronized (monitor2){
                System.out.println(this.getName() + " - STATE2" + " " + System.nanoTime() );
                int k1 = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
                for (int i = 0; i < k1 * 100000; i++) {
                    i++; i--;
                }

                System.out.println(this.getName() + " - STATE3" + " " + System.nanoTime());
                
            }
        }}}