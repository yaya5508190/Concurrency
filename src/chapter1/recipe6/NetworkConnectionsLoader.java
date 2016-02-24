package chapter1.recipe6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/2/24.
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connections loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("network connections loading has finished: %s\n", new Date());
    }
}
