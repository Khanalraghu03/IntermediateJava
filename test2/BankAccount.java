/**
 *
 */
package test2;

import java.util.Date;

/**
 * @author apereira
 *
 */

public abstract class BankAccount {
    private int bankAccountNumber;
    protected double balance;
    private Date dateAccountCreated;
    private double serviceFee;
    /**
     * @param bankAccountNumber
     * @param balance
     * @param serviceFee
     */
    public BankAccount(int bankAccountNumber, double balance,
                       double serviceFee) {
        this.bankAccountNumber = bankAccountNumber;
        this.balance = balance;
        this.dateAccountCreated = new Date();
        this.serviceFee = serviceFee;
    }
    /**
     * @return the bankAccountNumber
     */
    public int getBankAccountNumber() {
        return bankAccountNumber;
    }
    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
    /**
     * @return the serviceFee
     */
    public double getServiceFee() {
        return serviceFee;
    }
    /**
     * @param serviceFee the serviceFee to set
     */
    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BankAccount [\nbankAccountNumber=" + bankAccountNumber
                + ", \nbalance=" + balance
                + ", \ndateAccountCreated=" + dateAccountCreated
                + ", \nserviceFee=" + serviceFee
                + "]";
    }
    /**
     * @param amount
     * @return the balance
     */
    public  double deposit(double amount){
        return balance += amount;
    }
    /**
     * @param amount
     * @return the balance
     */
    public double defaultWithdraw(double amount){
        return balance -= amount;
    }
    /**
     * @param sourceAccount
     * @param amount
     * @return the transfer is successful or not
     */
    public boolean transferFunds(BankAccount sourceAccount, double amount){
        if(sourceAccount.getBalance()==sourceAccount.withdraw(amount))
            return false;
        else{
            this.deposit(amount);
            return true;
        }
    }
    /**
     * @param amount
     * @return
     */
    public abstract double withdraw(double amount);
    /**
     * @return the serviceFee
     */
    public abstract double deductServiceFee();
}