package chapter13;

public class TestBankAccount {
	public static void main(String[] args) {
		/**
		 * Create an object of class CertificatesOfDepositAccount
		 * 	with accountNumber = 341112, balance = 2000.0, 
		 * 	accountMaintendenceFee = 20.0, numberOfMonths = 12 and
		 * 	accountOpen = true*/
		CertificatesOfDepositAccount cdAccount = new CertificatesOfDepositAccount(341112, 2000.0, 20.0, 12, true);
		
		//Set the annualInterestRate = 12.0 and minimum balance = 500.0
		CertificatesOfDepositAccount.setAnnualInterestRate(12.0);
		CertificatesOfDepositAccount.setMinimumBalance(500.0);
		
		System.out.println(cdAccount);
	}
}
