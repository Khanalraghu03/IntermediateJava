package test2;
/**
 * @author Raghu Khanal
 *
 */

public class MoneyMarketAccount extends BankAccount {

    private MoneyMarketInterestRate rate;
    private static double minimumBalance = 7500.0;

    public MoneyMarketAccount(int bankAccountNumber,double balance, double serviceFee,
                              MoneyMarketInterestRate rate) {
        super(bankAccountNumber,balance,serviceFee);
        this.rate = rate;
    }

    //Getters
    public MoneyMarketInterestRate getRate() {
        return rate;
    }

    public static double getMinimumBalance() {
        return minimumBalance;
    }

    //Setters
    public void setRate(MoneyMarketInterestRate rate) {
        this.rate = rate;
    }

    public static void setMinimumBalance(double minimumBalance) {
        MoneyMarketAccount.minimumBalance = minimumBalance;
    }

    //toString
    @Override
    public String toString() {
        return super.toString();
    }



    //Methods
    @Override
    public double withdraw(double amount) {
        if(amount > balance) {
            return balance;
        }
        return super.defaultWithdraw(amount);
    }

    @Override
    public double deductServiceFee() {
        if(balance < minimumBalance) {
            return withdraw(balance);
        }
        return balance;

    }

    public double computeMoneyMarketInterest() {
        return (balance * rate.getMoneyMarketInterestRate() * 0.01);
    }
}
