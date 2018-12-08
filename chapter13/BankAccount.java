package chapter13;

/**
 * 
 */

import java.util.Date;

/**
 * @author Raghu Khanal
 *
 */

//Programmers use abstract classes to not only provide functionality 
	//but also defer some implementation to the subclasses. In other 
	//words an abstract class can force the subclasses to implement
	//certain methods. This is done by defining abstract methods in 
	//the super class.
//Abstract classes can be extended but you cannot create an object from an abstract class

public abstract class BankAccount {
	private int bankAccountNumber;
	private double balance;
	private Date dateAccountCreated;
	private double accountMaintendenceFee;
	/**
	 * @param bankAccountNumber
	 * @param balance
	 */
	public BankAccount(int bankAccountNumber, double balance, double accountMaintendenceFee) {
		this.bankAccountNumber = bankAccountNumber;
		this.balance = balance;
		this.dateAccountCreated = new Date();
		this.accountMaintendenceFee = accountMaintendenceFee;
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
	 * @return the accountMaintendenceFee
	 */
	public double getAccountMaintendenceFee() {
		return accountMaintendenceFee;
	}
	/**
	 * @param accountMaintendenceFee the accountMaintendenceFee to set
	 */
	public void setAccountMaintendenceFee(double accountMaintendenceFee) {
		this.accountMaintendenceFee = accountMaintendenceFee;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#sString()
	 */
	@Override
	public String toString() {
		return "BankAccount [\nbankAccountNumber=" + bankAccountNumber 
				+ ", \nbalance=" + balance 
				+ ", \ndateAccountCreated=" + dateAccountCreated 
				+ ", \naccountMaintendenceFee=" + accountMaintendenceFee
				+ "]\n";
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
	public double withdraw(double amount){
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
	
	public abstract double deductAccountMaintenanceFee();
	
	
	
	
	
	
}