package practice.ch19;

import java.util.ArrayList;
import java.util.Date;

public class Check {
	public static void main(String[] args) {
	
	//19.1a
	ArrayList dates = new ArrayList();
	dates.add(new Date());
	dates.add(new String("hey")); //Incorrect: logical error, gets caught only through generic typing
	
	System.out.println(dates.get(0));
	System.out.println(dates.get(1));
	
	//19.1b
	ArrayList<Date> date = new ArrayList<>();
	date.add(new Date());
//	date.addAll(new String()); //String not applicable for date: better
	
	//19.2a
	ArrayList dates2 = new ArrayList();
	dates2.add(new Date());
//	Date date2 = dates2.get(0); //Gotta cast Date
	Date date2 = (Date)dates2.get(0);
	System.out.println("Date: " +date2);
	
	
	//19.2b
	ArrayList<Date> datess = new ArrayList<>();
	datess.add(new Date());
	Date date3 = datess.get(0);
	System.out.println(date3);
	
	
	
	
	
	}
}
