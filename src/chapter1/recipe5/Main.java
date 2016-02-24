package chapter1.recipe5;

import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/2/24.
 */
public class Main {
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
