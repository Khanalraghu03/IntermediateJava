package test2;

import java.io.File;
/**
 * @author Raghu Khanal
 *
 */

public class TestMoneyMarketAccount {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.home") + File.separatorChar
				+ "desktop" + File.separatorChar + "MoneyMarket" + File.separatorChar
				+ "money_market_interest_rate.txt");

        MoneyMarketInterest rate = new MoneyMarketInterest(5.5,file);
        MoneyMarketAccount initialObj = new MoneyMarketAccount(100,100,10,rate);

       rate.printMoneyMarketInterests();
//       rate.readMoneyMarketInterestRateFromFile();
        System.out.println(initialObj.computeMoneyMarketInterest());

    }
}
