package chapter1.recipe2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 35737 on 2016/2/23.
 */
public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] status = new Thread.State[10];
        PrintWriter pw = null;
        FileWriter fw = null;
        boolean finish = false;

        try {
            File file = new File(".\\data\\log.txt");
            file.getParentFile().mkdirs();
            file.createNewFile();

            fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(new Calculator(i));
                if ((i % 2) == 0) {
                    threads[i].setPriority(Thread.MAX_PRIORITY);
                } else {
                    threads[i].setPriority(Thread.MIN_PRIORITY);
                }
                threads[i].setName("Thread " + i);

                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread
            thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
