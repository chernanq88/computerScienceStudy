package threadpool;

import java.util.concurrent.BlockingQueue;

public class WorkingThread implements Runnable{

    Thread localThreadReference = null;
    private BlockingQueue<Runnable> tasks=null;
    private boolean isStopped;

    public WorkingThread(BlockingQueue<Runnable> tasks){
        this.tasks=tasks;
        this.isStopped=false;
    }

    @Override
    public void run() {
        localThreadReference= Thread.currentThread();
        var name=Thread.currentThread().getName();
        System.out.println("Thread started " + name);

        while(!isStopped){
            try {
                Runnable task=tasks.take();
                task.run();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " Stopped");
            }
        }

    }

    public synchronized void stop(){
        this.isStopped=true;
        this.localThreadReference.interrupt();
    }
}
