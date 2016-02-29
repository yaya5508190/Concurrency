package chapter1.recipe8;

/**
 * Created by 35737 on 2016/2/29.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        //thread.setUncaughtExceptionHandler(new ExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
