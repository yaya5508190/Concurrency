package chapter2.recipe3;

/**
 * Created by 35737 on 2016/3/14.
 */
public class Producer implements Runnable {
    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        //System.out.println("Producer" + Thread.currentThread().getState());
        for (int i = 0; i < 100; i++) {
            //System.out.println("Producer" + Thread.currentThread().getState());
            eventStorage.set();
        }
    }
}
