package chapter10;
import java.util.Date;
public class Loan {
    private int loanNumber;
    private double loanAmount;
    private int numberOfYears;
    private double annualInterestRate;
    private Date dateLoanCreated;
    private int bankAccountNumber;
    //Immutable object is an object which state cannot be changed.
    final static int branchCode = 1001;
    static int numberOfLoansCreated;

    /**
     * Default (no args) constructor
     */
    public Loan() {
//        this.loanNumber = 10001;
//        this.loanAmount = 1000.0;
//        this.numberOfYears = ;
//        this.annualInterestRate = 2.5;
//        this.dateLoanCreated = new Date();
//        this.bankAccountNumber = 1200021;
//        Loan.numberOfLoansCreated++;

  	this(10001, 1000.0, 1,2.5,1200021);
    }

	public Loan(int loanNumber, double loanAmount, int numberOfYears, double annualInterestRate,
			int bankAccountNumber) {
		super();
		this.loanNumber = loanNumber;
		this.loanAmount = loanAmount;
		this.numberOfYears = numberOfYears;
		this.annualInterestRate = annualInterestRate;
		this.dateLoanCreated = new Date();
		this.bankAccountNumber = bankAccountNumber;
		Loan.numberOfLoansCreated++;
	}

	/**
	 * @return the loanNumber
	 */
	public int getLoanNumber() {
		return loanNumber;
	}

	/**
	 * @return the loanAmount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @return the numberOfYears
	 */
	public  int getNumberOfYears()
	{
		return numberOfYears;
	}
	/**
	 * @return the annualInterestRate
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/**
	 * @return the dateLoanCreated
	 */
	public Date getDateLoanCreated() {
		return dateLoanCreated;
	}

	/**
	 * @return the bankAccountNumber
	 */
	public int getBankAccountNumber() {
		return bankAccountNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nLoan [loanNumber=" + loanNumber + ", loanAmount=" + loanAmount + ", numberOfYears=" + numberOfYears
				+ ", annualInterestRate=" + annualInterestRate + ", dateLoanCreated=" + dateLoanCreated
				+ ", bankAccountNumber=" + bankAccountNumber + "]";
	}

	/**
	 * @return the branchCode
	 */
	public static int getBranchCode() {
		return branchCode;
	}

	/**
	 * @return the numberOfLoansCreated
	 */
	public static int getNumberOfLoansCreated() {
		return numberOfLoansCreated;
	}
	public double getMontlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200.0;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1/(1 + monthlyInterestRate), numberOfYears *12));
		return monthlyPayment;
	}
	public double getTotalPayment() {
		double totalPayment = getMontlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
}