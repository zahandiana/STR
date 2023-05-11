/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1.app1;

/**
 *
 * @author diana
 */
public class Main {
    public static void main(String[] args) {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);

        new ExecutionThread(monitor1,2,5,5).start();
        new ExecutionThread2(monitor1,monitor2,2,4,4).start();
        new ExecutionThread2(monitor1,monitor2,3,6,3).start();
    }}
