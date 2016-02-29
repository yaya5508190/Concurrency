package chapter1.recipe9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/2/29.
 */
public class UnsafeTask implements Runnable {
    private Date startDate = new Date();

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }
}
