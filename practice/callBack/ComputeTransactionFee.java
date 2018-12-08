package practice.callBack;

public class ComputeTransactionFee implements TransactionFeeRate{
	private double rate;
	
	public ComputeTransactionFee(double rate) {
		this.rate = rate;
	}
	
	@Override
	public double getTransactionFeeRate() {
		// TODO Auto-generated method stub
		return rate;
	}
	
	public double getTransactionFee() {
		SavingsAccountt saving = new SavingsAccountt(1111,1133,100,this);
		return saving.computeTransactionFee();
		
	}

}
