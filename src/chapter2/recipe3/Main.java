package chapter2.recipe3;

import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/3/14.
 */
public class Main {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Thread thread1=new Thread(producer);
        Consumer consumer = new Consumer(eventStorage);
        Thread thread2=new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
