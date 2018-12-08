package practice.callBack;

public class TestComputeTransactionFee {
	public static void main(String[] args) {
	ComputeTransactionFee computeFee = new ComputeTransactionFee(0.035);
	System.out.println("The fee is " + computeFee.getTransactionFee());
	
	}
}
