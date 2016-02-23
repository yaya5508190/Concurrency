package chapter1.recipe4;

import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/2/23.
 */
public class Main {
    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("C:\\", "MSTTSEngine.dll");
        Thread thread = new Thread(searcher);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
