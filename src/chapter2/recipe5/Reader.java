package chapter2.recipe5;

/**
 * Created by 35737 on 2016/3/21.
 */
public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f %s: Price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1(),Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
