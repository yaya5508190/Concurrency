package chapter2.recipe3;

import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/3/14.
 */
public class Consumer implements Runnable {
    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        //System.out.println("Consumer" + Thread.currentThread().getState());
        for (int i = 0; i < 100; i++) {
            //System.out.println("Consumer" + Thread.currentThread().getState());
            eventStorage.get();
        }
    }
}
