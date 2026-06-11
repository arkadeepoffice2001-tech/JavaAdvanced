package MultiThreading;

public class ThreadHandler {

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeDemo account=new ThreadSafeDemo(10000);
        Thread thread1= new Thread( ()-> account.Deposit(2500),"T1");
        Thread thread2= new Thread( ()-> account.Deposit(2500),"T2");
        Thread thread3= new Thread( ()-> account.Deposit(2500),"T3");
        Thread thread4= new Thread( ()-> account.Deposit(2500),"T4");
        Thread thread5= new Thread( ()-> account.Withdraw(5000),"T5");
        Thread thread6= new Thread( ()-> account.Withdraw(2500),"T6");

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        // Wait for all threads to finish
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();


        System.out.println("final balance "+ account.getBalance());
    }
}
