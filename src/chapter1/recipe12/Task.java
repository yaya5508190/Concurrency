package chapter1.recipe12;

import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/3/1.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
