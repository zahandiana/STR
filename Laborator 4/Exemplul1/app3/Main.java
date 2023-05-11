/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1.app3;

/**
 *
 * @author diana
 */
public class Main {
    
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
       
        new ex1.app3.ExecutionThread(monitor, 5,3,6).start();
        new ex1.app3.ExecutionThread(monitor, 3,4,7).start();
        new ex1.app3.ExecutionThread(monitor, 6,7,5).start();
    }
}