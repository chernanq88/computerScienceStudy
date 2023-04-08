package Threading;

public class InterruptingThreads {

    public static void main(String[] args) throws InterruptedException {

        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000000000;i++){
                        System.out.println(i);
                        if(Thread.interrupted()) {
                            System.out.println("Thread Interrupted");
                            break;
                        }

                }
            }
        };

        Thread threadTest= new Thread(r);

        threadTest.start();

        Thread.sleep(5000);

        threadTest.interrupt();

        Thread.sleep(10000);



    }

}
