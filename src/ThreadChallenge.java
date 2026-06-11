public class ThreadChallenge {

    public static void main(String args[]) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread thread2 = new Thread(new Thread2());



        Thread threadMonitor=new Thread(()->{

            long now = System.currentTimeMillis();

            while (thread1.isAlive()) {
                try {
                    Thread.sleep(1000);

                    if (System.currentTimeMillis() - now > 2000) {
                        thread1.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("The thread "+ thread1.getName()+" has been interrupted");
                }
            }
            System.out.print("\nstate of thread1: " + thread1.getState());

            if(thread1.isInterrupted()){
                thread2.interrupt();
            }
            System.out.print("\nstate of thread2: " + thread2.getState());

        },"threadMonitor");


        threadMonitor.start();
        thread1.start();
        thread1.join();
        thread2.start();

    }



}






 class Thread1 extends  Thread {

     @Override
     public void run() {


         for (int i = 1; i <= 10; i += 2) {
             if(Thread.currentThread().isInterrupted()) return;
             System.out.printf("%d\n", i);

             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                 return;
             }
         }
     }

 }

class Thread2 implements Runnable{

    @Override
    public void run(){


        for(int i=2;i<=10;i+=2) {
            if(Thread.currentThread().isInterrupted()) return;
            System.out.printf("%d\n", i);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}


/*
Correcting a common misconception
What beginners often think	What actually happens
thread.interrupt() stops the thread immediately.	It only sets a flag.
An interrupted thread will die.	It dies only if its code checks the flag and exits (e.g., if (Thread.interrupted()) return;).
Catching InterruptedException clears the interruption.	Yes, but calling Thread.currentThread().interrupt() restores it – yet the thread still runs unless you add break or return.
 */