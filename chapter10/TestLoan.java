package chapter10;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class TestLoan
{
	public static void main(String[] args) 
	{
		Loan loan1 = new Loan();
		System.out.println(loan1);
		System.out.printf("The monthly payment of the loan = %.2f\n",
				loan1.getMontlyPayment());
		System.out.printf("The total payment of the loan = %.2f\n",
				loan1.getTotalPayment());

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the loan number: ");
		int loanNumber = input.nextInt();
		
		System.out.print("Enter the loan amount: ");
		double loanAmount = input.nextDouble();
		
		System.out.print("Enter the number of years: ");
		int numOfYears = input.nextInt();
		
		System.out.print("Enter the annual rate: ");
		double annualInterestRate = input.nextDouble();
		
		System.out.print("Enter the account number: ");
		int accountNumber = input.nextInt();
		
		Loan loan2 = new Loan(loanNumber, loanAmount,numOfYears,annualInterestRate, accountNumber);
		System.out.println(loan2);
		System.out.printf("The monthly payment of the loan = %.2f\n",
				loan2.getMontlyPayment());
		System.out.printf("The total payment of the loan = %.2f\n",
				loan2.getTotalPayment());
		
		input.close();
		//Unchanged Date
		System.out.println("The unchanged date loan created for loan 2 is "+ loan2.getDateLoanCreated());
		
		System.out.println("The number of Loan objects created = " + Loan.getNumberOfLoansCreated());
		System.out.println("The branch code = " + Loan.getBranchCode());

//		int numOfYears1 = loan2.getNumberOfYears();
//		System.out.println("The number of years for loan2 = " + numOfYears1);
//		numOfYears1 = 30;
//		System.out.println("The number of years for loan2 = " + numOfYears1);
//		System.out.println("The number of years for loan2 = " + loan2.getNumberOfYears());


		Date dateLoanCreatedLocalVar = loan2.getDateLoanCreated();
		long loan2DateCreated= (long)dateLoanCreatedLocalVar.getTime();
		long reducedYearBy = 1000L*60*60*24*365;
		System.out.println("Reduced by year is "+ reducedYearBy);
		dateLoanCreatedLocalVar.setTime(loan2DateCreated - reducedYearBy);
//		dateLoanCreatedLocalVar.setTime(loan2DateCreated.parse() - 1000*60*60*24*365+57909110);
		
		//Changed Date
		System.out.println("The changed date loan created for loan 2 is "+ dateLoanCreatedLocalVar);
		System.out.println("The changed date loan created for loan 2 is "+ loan2.getDateLoanCreated());
//		dateLoanCreatedLocalVar.setTime(1000);
		//Loan.numberOfLoansCreated = 5;
		
		Loan[] loans = new Loan[15];
		for(int i = 0; i < loans.length; i++) 
		{
			//Generate random number for loan amount 1000.0(inclusive)
			//to 500000.0 exclusive
			double randomLoanAmount = ThreadLocalRandom.current().nextDouble(1000.0,500000.0);
			double randomLoanAmountRound = Math.round(randomLoanAmount * 100) / 100.0;		
			System.out.println(randomLoanAmountRound);
			
			//Generate random number for interest rate 2.0(inclusive)
			//to 10.0 exclusive
			double randomAnnualInterestRate = ThreadLocalRandom.current().nextDouble(2.0,10.0);
			double randomAnnualInterestRateRound = Math.round(randomAnnualInterestRate * 100) / 100.0;		
			System.out.println(randomAnnualInterestRateRound);
			
			//Generate sequential random number of years
			int randomNumberOfYears = ThreadLocalRandom.current().nextInt(1,26);
			
			//Generate sequential loan Number
			int loanNumberSuquential = 10003 + i;
			
			//Generate sequential bankAccountNumber
			int bankAccountNumberSequential = 1200023 + i;
			
			//Create a Loan object using the above generated parameters
			Loan loan = new Loan(loanNumberSuquential,randomLoanAmountRound,
					randomNumberOfYears,randomAnnualInterestRateRound,bankAccountNumberSequential);
			loans[i] = loan;
		}
		System.out.println(Arrays.toString(loans));
		
		double sum= 0.0;
		for(Loan loan: loans) 
		{
			sum += loan.getLoanAmount();
		}
		double avg = sum / loans.length;
		System.out.printf("The average of the Loan amounts in the array =%.2f\n",avg);
		
		
		double randomLoanAmount = ThreadLocalRandom.current().nextDouble(1000.0,500000.0);
		double randomLoanAmountRound = Math.round(randomLoanAmount * 100) / 100.0;		
		System.out.println(randomLoanAmountRound);
		
		//Generate random number for interest rate 2.0(inclusive)
		//to 10.0 exclusive
		double randomAnnualInterestRate = ThreadLocalRandom.current().nextDouble(2.0,10.0);
		double randomAnnualInterestRateRound = Math.round(randomAnnualInterestRate * 100) / 100.0;		
		System.out.println(randomAnnualInterestRateRound);
		
		//Generate sequential random number of years
		int randomNumberOfYears = ThreadLocalRandom.current().nextInt(1,26);
		
		//Generate sequential loan Number
		int loanNumberSuquential = 10003 + 15;
		
		//Generate sequential bankAccountNumber
		int bankAccountNumberSequential = 1200023 + 15;
		
		//Create a Loan object and add it to the end of the other objects
		Loan loan3 = new Loan(loanNumberSuquential,randomLoanAmountRound,randomNumberOfYears,randomAnnualInterestRate,bankAccountNumberSequential);
		
		Loan[] loansExtended = Arrays.copyOf(loans, loans.length*2);
		loansExtended[loans.length] = loan3;
		
		System.out.println(Arrays.toString(loansExtended));
		
		//Using an ArrayList to store and add Loan objects
		ArrayList<Loan> listLoans = new ArrayList<Loan>(15);
		
		
		for(int i = 0; i < loans.length; i++) 
		{
			//Generate random number for loan amount 1000.0(inclusive)
			//to 500000.0 exclusive
			double randomLoanAmount2 = ThreadLocalRandom.current().nextDouble(1000.0,500000.0);
			double randomLoanAmountRound2 = Math.round(randomLoanAmount2 * 100) / 100.0;		
			System.out.println(randomLoanAmountRound2);
			
			//Generate random number for interest rate 2.0(inclusive)
			//to 10.0 exclusive
			double randomAnnualInterestRate2 = ThreadLocalRandom.current().nextDouble(2.0,10.0);
			double randomAnnualInterestRateRound2 = Math.round(randomAnnualInterestRate2 * 100) / 100.0;		
			System.out.println(randomAnnualInterestRateRound2);
			
			//Generate sequential random number of years
			int randomNumberOfYears2 = ThreadLocalRandom.current().nextInt(1,26);
			
			//Generate sequential loan Number
			int loanNumberSuquential2 = 10003 + i;
			
			//Generate sequential bankAccountNumber
			int bankAccountNumberSequential2 = 1200023 + i;
			
			//Create a Loan object using the above generated parameters
			Loan loan5 = new Loan(loanNumberSuquential2,randomLoanAmountRound2,
					randomNumberOfYears2,randomAnnualInterestRateRound2,bankAccountNumberSequential2);
			listLoans.add(loan5);
		}
		System.out.println("\n The following are object in the ArrayList ");
		System.out.println(listLoans);
		
		System.out.println("\nThe ArrayList after inserting a new object to the end of the list");
		
		double randomLoanAmount2 = ThreadLocalRandom.current().nextDouble(1000.0,500000.0);
		double randomLoanAmountRound2 = Math.round(randomLoanAmount2 * 100) / 100.0;		
		System.out.println(randomLoanAmountRound2);
		
		//Generate random number for interest rate 2.0(inclusive)
		//to 10.0 exclusive
		double randomAnnualInterestRate2 = ThreadLocalRandom.current().nextDouble(2.0,10.0);
		double randomAnnualInterestRateRound2 = Math.round(randomAnnualInterestRate2 * 100) / 100.0;		
		System.out.println(randomAnnualInterestRateRound2);
		
		//Generate sequential random number of years
		int randomNumberOfYears2 = ThreadLocalRandom.current().nextInt(1,26);
		
		//Generate sequential loan Number
		int loanNumberSuquential2 = 10003 + 15;
		
		//Generate sequential bankAccountNumber
		int bankAccountNumberSequential2 = 1200023 + 15;
		
		//Create a Loan object using the above generated parameters
		Loan loan5 = new Loan(loanNumberSuquential2,randomLoanAmountRound2,
				randomNumberOfYears2,randomAnnualInterestRateRound2,bankAccountNumberSequential2);
		listLoans.add(loan5);
		System.out.println(listLoans);
		
		
		Loan loan6 = new Loan(20003,randomLoanAmountRound2,
				randomNumberOfYears2,randomAnnualInterestRateRound2,bankAccountNumberSequential2);
		listLoans.add(5,loan6);
		System.out.println("ArrayList after inserting a new Loan object at index 5");
		System.out.println(listLoans);
		
		Loan loanAtIndex5 = listLoans.remove(5);
		System.out.println("The loan number of object at index 5 = " + loanAtIndex5.getLoanNumber());
		System.out.println("ArrayList after removing object at index 5");
		
		System.out.println(listLoans);
		
		int[] numbers = new int[1000000];
		for(int i = 0; i < numbers.length; i++) {
			int randomInteger = ThreadLocalRandom.current().nextInt(100,100000);
			numbers[i] = randomInteger;
		}
		//Note start time
		long startTime = System.currentTimeMillis();
		Arrays.sort(numbers);
		long endTime = System.currentTimeMillis();
		System.out.println("Number of miliseconds to sort the array = " + (endTime - startTime));
		
		ArrayList<Integer> listOfIntegers = new ArrayList<> (1000000);
		
		for(int i = 0; i < numbers.length; i++) 
		{
			int randomInteger = ThreadLocalRandom.current().nextInt(100,100000);
//			Integer num = new Integer(randomInteger);
			Integer num = randomInteger;
			listOfIntegers.add(num);
		}
		long startTime1 = System.currentTimeMillis();
		Collections.sort(listOfIntegers);
		long endTime1 = System.currentTimeMillis();
		System.out.println("Number of miliseconds to sort the ArrayList = " + (endTime1 - startTime1));
		
		
	}
}