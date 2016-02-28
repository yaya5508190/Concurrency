package chapter1.recipe7;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by 35737 on 2016/2/28.
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);//�ػ��߳��ӳ����� ���NoSuchElementException
            while (true) {
                Date date = new Date();
                clean(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete = false;
        if (deque.size() > 0) {
            //deque.size����0ʱ deque.getLastδ����ȡ���п�������Ϊinsert�����ȼ�1Ȼ���ٲ����м��м������getLast NoSuchElementException
            do {
                Event e = deque.getLast();
                difference = date.getTime() - e.getDate().getTime();
                if (difference > 10000) {
                    System.out.printf("Cleaner: %s\n", e.getEvent());
                    deque.removeLast();
                    delete = true;
                }
            } while (difference > 10000);
            if (delete) {
                System.out.printf("Cleaner: Size of the queue: %d\n", deque.size());
            }
        }
    }
}
