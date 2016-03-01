package chapter1.recipe11;

/**
 * Created by 35737 on 2016/3/1.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadGroup threadGroup=new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup,task);
            thread.start();
        }
    }
}
