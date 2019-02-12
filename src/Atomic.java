import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by gexiaoshan on 2018/7/26.
 */
public class Atomic {

    public static void main(String[] args) throws InterruptedException {
//        dfasd111();
    }

    private static AtomicReference<Integer> ar = new AtomicReference<Integer>(0);

    public static void dfasd111() throws InterruptedException {
        int t = 100;
        final int c = 100;
        final CountDownLatch latch = new CountDownLatch(t);
        for (int i = 0; i < t; i++) {
            new Thread(() -> {
                for (int j = 0; j < c; j++) {
                    while (true) {
                        Integer temp = ar.get();
                        if (ar.compareAndSet(temp, temp + 1)) {
                            break;
                        }
                    }
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(ar.get()); //10000000
    }




}
