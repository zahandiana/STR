/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1.app3;

/**
 *
 * @author diana
 */
public class ExecutionThread extends Thread{
    Integer monitor;
   
    int activity_min, activity_max, sleep;
 
 public ExecutionThread(Integer monitor, int activity_min, int activity_max, int sleep){
        this.monitor=monitor;
        
        this.activity_min=activity_min;
        this.activity_max=activity_max;
        
        this.sleep=sleep;
    }

    public void run(){
        while(true){
        System.out.println(this.getName() + "START");
        
        synchronized (monitor){
                       System.out.println(this.getName() + " - STATE1" + " " + System.nanoTime() );
                int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++; i--;
        }
     }
         System.out.println(this.getName() + " - STATE2" + " " + System.nanoTime());
         
                  try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
                
            }

           System.out.println(this.getName() + " - STATE3" + " " + System.nanoTime());
            }
        }}