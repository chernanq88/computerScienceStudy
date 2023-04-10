package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadpoolQuintana {

    private BlockingQueue<Runnable> tasks = null;
    private List<WorkingThread> workingThreads=null;
    private boolean isStopped;

    public ThreadpoolQuintana(int numberOfTasks, int numberOfThreads){
        workingThreads= new ArrayList<>();
        tasks=new ArrayBlockingQueue<>(numberOfTasks);

        for (int i=0;i<numberOfThreads;i++){
            workingThreads.add(new WorkingThread(tasks));
        }

        WorkingThread threadJuanito= new WorkingThread(tasks);
        workingThreads.add(threadJuanito);
        new Thread(threadJuanito,"Juanito").start();

        for(WorkingThread workingThread:  workingThreads){
            new Thread(workingThread).start();
        }
    }

    public synchronized void execute(Runnable task){
        tasks.offer(task);
    }

    public synchronized void waitUntilAllTasksFinished() {
        while(this.tasks.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All tasks finished");
    }


    public synchronized void doStop() {
        workingThreads.forEach(WorkingThread::stop);
    }
}
