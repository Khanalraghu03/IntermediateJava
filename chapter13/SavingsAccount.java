package chapter13;

/**
 * 
 */

/**
 * @author Raghu Khanal
 *
 */
public class SavingsAccount extends BankAccount {
	private static double annualInterestRate = 4.5;
	private static double minimumBalance = 100;
	/**
	 * @param bankAccountNumber
	 * @param balance
	 */
	public SavingsAccount(int bankAccountNumber, double balance, double accountMaintendenceFee) {
		super(bankAccountNumber, balance, accountMaintendenceFee);
	}
	/**
	 * @return the annualInterestRate
	 */
	public static double getAnnualInterestRate() {
		return SavingsAccount.annualInterestRate;
	}
	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}
	
	/**
	 * @return the minimumBalance
	 */
	public static double getMinimumBalance() {
		return minimumBalance;
	}
	/**
	 * @param minimumBalance the minimumBalance to set
	 */
	public static void setMinimumBalance(double minimumBalance) {
		SavingsAccount.minimumBalance = minimumBalance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [toString()=" + super.toString() 
		+ "" 
		+ "]";
	}
	/* (non-Javadoc)
	 * @see chapter11.bankaccounts.BankAccount#withdraw(double)
	 */
	@Override
	public double withdraw(double amount){
		if(amount > this.getBalance())
			return this.getBalance();
		else
			return super.withdraw(amount);
	}
	/**
	 * @return the monthly interest
	 */
	public double getMonthlyInterest(){
		return SavingsAccount.annualInterestRate/1200.0 * this.getBalance();
	}
	/**
	 * @return the balance
	 */
	public double addMonthlyInterest(){
		return this.deposit(this.getMonthlyInterest());
	}
	@Override
	public double deductAccountMaintenanceFee() {
		
		//if the account balance is lesser than the minimum
		//balance, then call the withdraw method to deduct 
		//the account maintenance fee. Return the account balance
		//after the withdrawal
		
		if(this.getBalance() < SavingsAccount.minimumBalance) {
			return this.withdraw(this.deductAccountMaintenanceFee());
			
		}
		else {
			return this.getBalance();
		}
		
		
	}
	
}

