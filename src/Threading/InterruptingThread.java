package Threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterruptingThread implements Runnable{

    private BlockingQueue<Runnable> blockingQueue;

    public InterruptingThread(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public static void main(String[] args) {


        BlockingQueue<Runnable> tasks=new ArrayBlockingQueue<>(10);
        InterruptingThread t1= new InterruptingThread(tasks);

        Thread thread1=new Thread(t1);
        thread1.start();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public void run() {

        while (true){
            blockingQueue.add(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Mytask");
                }
            });
        }

    }
}
