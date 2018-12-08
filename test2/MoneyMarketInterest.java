package test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @author Raghu Khanal
 *
 */
public class MoneyMarketInterest implements MoneyMarketInterestRate {
    private double interestRate;
    private File file;



    public MoneyMarketInterest(double interestRate, File file) {
        this.interestRate = interestRate;
        this.file = file;
    }

    @Override
    public double getMoneyMarketInterestRate() {
        return interestRate;
    }

    public void readMoneyMarketInterestRateFromFile() {
        //Uses file with Scanner to read the money market interest
        //rate from the text file
        //eliminates the % sign, and converts the String to a double
        //and assigns it to the instance variable interestRate;
        Scanner readFile = null;
        String textCopy;
        String store[];
        Double num;
        try {
            readFile = new Scanner(file);
            textCopy = readFile.nextLine();
            store = textCopy.split("%");
            //store[0] = 7.5

            num = Double.parseDouble(store[0]);
            interestRate = num;
//            System.out.println(interestRate);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(file + " not found");
        } catch (NumberFormatException ex) { //If there is string in the text file other than number
            ex.printStackTrace();
            System.out.println("Cannot convert String to Number");
        }
        if (readFile != null) {
            readFile.close();
        }
    }

    public void printMoneyMarketInterests() {
        readMoneyMarketInterestRateFromFile();

        MoneyMarketAccount obj1 = new MoneyMarketAccount(1111111, 5000.0, 100.0, this);
        MoneyMarketAccount obj2 = new MoneyMarketAccount(2222222, 6000.0, 100.0, this);
        MoneyMarketAccount obj3 = new MoneyMarketAccount(3333333, 7000.0, 100.0, this);

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        obj1.deductServiceFee();
        System.out.println(obj1.computeMoneyMarketInterest());

        obj2.deductServiceFee();
        System.out.println(obj2.computeMoneyMarketInterest());

        obj3.deductServiceFee();
        System.out.println(obj3.computeMoneyMarketInterest());
    }
}
