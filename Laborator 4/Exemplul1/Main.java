/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

/**
 *
 * @author diana
 */
public class Main {
    public static void main(String[] args) {
        Integer monitor = new Integer(1);
        
        new ExecutionThread(monitor, 2, 4, 3, 6).start();
        new ExecutionThread(monitor, 3, 5, 4, 7).start();
    }
}

