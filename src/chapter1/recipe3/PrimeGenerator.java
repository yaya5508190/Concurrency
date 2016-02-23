package chapter1.recipe3;

/**
 * Created by 35737 on 2016/2/23.
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        int number = 0;
        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }
            if (this.isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
