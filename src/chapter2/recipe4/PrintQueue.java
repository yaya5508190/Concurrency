package chapter2.recipe4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 35737 on 2016/3/16.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        queueLock.lock();
        FileWriter fw = null;
        try {
            //Long duration = (long) (Math.random() * 1500);
            //System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 1000) + "seconds");
            //Thread.sleep(duration);
            File file = new File("D:\\Job.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file,true);
            fw.write(Thread.currentThread().getName()+"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            queueLock.unlock();
        }
    }
}
