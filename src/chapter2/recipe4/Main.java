package chapter2.recipe4;

import java.io.File;

/**
 * Created by 35737 on 2016/3/16.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();
        File file = new File("D:\\Job.txt");
        file.delete();
        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread "+ i);
        }
        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }
}
