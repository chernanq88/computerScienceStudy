package threadpool;

import java.util.Random;

public class MainThread {

    public static void main(String[] args) {

        ThreadpoolQuintana threadpoolQuintana=
                new ThreadpoolQuintana(20,5);

        for (int i=0;i<20;i++){
            final int taskId=i;

            Runnable runnable=() -> {

                System.out.println("This is the task " +taskId + " attended by " + Thread.currentThread().getName());
                try {
                    Random r = new Random();
                    int low = 10;
                    int high = 15;
                    int result = r.nextInt(high-low) + low;

                    Thread.sleep(500 * result);
                } catch (InterruptedException e) {
                }
            };
            threadpoolQuintana.execute(runnable);

        }

        threadpoolQuintana.waitUntilAllTasksFinished();
        threadpoolQuintana.doStop();

    }

}
