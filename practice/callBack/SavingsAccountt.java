package practice.callBack;

import chapter13.BankAccount;
public class SavingsAccountt extends BankAccount{
	private TransactionFeeRate rate;
	
	public SavingsAccountt(int bankAccountNumber, double balance, double accountMaintendenceFee, TransactionFeeRate rate) {
		super(bankAccountNumber, balance, accountMaintendenceFee);
		this.rate = rate;
	}
	
	@Override
	public double deductAccountMaintenanceFee() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double computeTransactionFee() {
		return super.getBalance() * rate.getTransactionFeeRate();
	}

}
