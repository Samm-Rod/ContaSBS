
package agency;

import client.Client;
public class Agency {
    private double balance;
    private boolean status;
    private int numAcc;
    private static int acc = 1;
    private final Client client;


    public Agency(Client client) {
        this.numAcc = Agency.acc;
        this.balance = 0;
        this.client = client;

        Agency.acc += 1;
    }

    public void deposit(double money){
        if(isStatus()){
            if(money > 0 && money < 5000){
                this.setBalance(getBalance() + money);
            }
        }else{
            System.out.println("No deposit !");
        }
    }

    public void withdraw(double money){
        if(isStatus()){
            if(money > 0 && money < 5000){
                this.setBalance(getBalance() - money);
            }else{
                System.out.println("No withdraw !");
            }
        }else{
            System.out.println("Closed account");
        }
    }

    public void transfer(Agency account, double money){
        if(isStatus()){
            if(money > 0 && money < getBalance()){       
                this.setBalance(getBalance() - money);
                account.setBalance(account.getBalance() + money);
            }else{
                System.out.println("No withdraw !");
            }
        }else{
            System.out.println("Closed account");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumAcc() {
        return numAcc;
    }

    public void setNumAcc(int numAcc) {
        this.numAcc = numAcc;
    }

    @Override
    public String toString() {
        return "\n          Statement Bank          " +
                "\nClient : " + this.client.getName() +
                "\nNumAcc : " + this.getNumAcc() +
                "\nStatus : " + this.isStatus()+
                "\nBalance : " + this.getBalance()+
                "\nTimes : "+this.client.getTimestamp()+
                "\n";
    }
}
