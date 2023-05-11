/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1.app2;

/**
 *
 * @author diana
 */
public class Main {
    
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);

        new ExecutionThread(monitor1, monitor2, 4,6,4).start();
        new ExecutionThread(monitor2,monitor1,5,7,5).start();
    }
}