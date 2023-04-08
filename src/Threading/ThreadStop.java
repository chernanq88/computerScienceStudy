package Threading;

public class ThreadStop {

    public static void main(String[] args) {

        MyThread thread1= new MyThread();
        thread1.start();

        try {

            System.out.println("Main thread after join");
            thread1.join();

        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception main thread");
            throw new RuntimeException(e);
        }

        System.out.println("Main thread");

    }


    static class MyThread extends Thread{

        private boolean toBeStoped;

        public void setToBeStoped(boolean toBeStoped) {
            this.toBeStoped = toBeStoped;
        }

        @Override
        public void run() {

            try {
                for (int i = 0; i<30; i++){
                    System.out.println("Thread executing cycle " + i);
                    Thread.sleep(1000);

                    if (toBeStoped)
                        break;


                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception thread "+ this.getName());
                throw new RuntimeException(e);
            }

            System.out.println("Thread finished");

        }
    }
}
