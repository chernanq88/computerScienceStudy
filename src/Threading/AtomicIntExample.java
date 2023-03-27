package Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntExample {

    public static void main(String[] args) {

        ExecutorService executorService = null;
        AtomicInteger counter = new AtomicInteger();
        try {
            executorService = Executors.newFixedThreadPool(2);

            Runnable task1 = () -> {
                for (int i = 1; i <= 20000; i++) {
                    counter.incrementAndGet();
                }
            };

            Runnable task2 = () -> {
                for (int i = 1; i <= 80000; i++) {
                    counter.incrementAndGet();
                }
            };

            executorService.submit(task1);
            executorService.submit(task2);
            executorService.awaitTermination(1, TimeUnit.SECONDS);

            System.out.println("Final counter Value:" + counter.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null)
                executorService.shutdown();
        }
    }
}