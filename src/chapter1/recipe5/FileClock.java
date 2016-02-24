package chapter1.recipe5;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/2/24.
 */
public class FileClock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                /**
                 * When Thread is sleeping and is interrupted, the method throws an InterruptedException
                 * exception immediately and doesn't wait until the sleeping time finishes.
                 */
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interrupted");
            }
        }
    }
}
