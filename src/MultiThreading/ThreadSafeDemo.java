package MultiThreading;

public class ThreadSafeDemo {
    private  Double balance;

    public ThreadSafeDemo(double initialDeposit){
        this.balance=initialDeposit;
    }


    public Double Deposit(double amount){

        synchronized(this) {
            balance = (balance + amount);
        }
        System.out.println("current balance: "+balance);
        return balance;
    }

    public Double Withdraw(double amount){
        synchronized(this) {
            balance=(balance-amount);
        }
        System.out.println("current balance: "+balance);
        return balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
