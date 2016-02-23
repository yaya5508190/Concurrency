package chapter1.recipe3;

import chapter1.recipe1.Calculator;

/**
 * Created by 35737 on 2016/2/23.
 */
public class Main {
    public static void main(String[] args){
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
