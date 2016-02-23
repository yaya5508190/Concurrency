package chapter1.recipe1;

/**
 * Created by 35737 on 2016/2/23.
 */
public class Main {
    public static void main(String[] args){
        for(int i = 1 ; i < 10 ; i++){
            Thread t = new Thread(new Calculator(i));
            t.start();
        }
    }
}
