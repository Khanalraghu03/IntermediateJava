/*
 * @author: Raghu Khanal
 * 
 * 
 * 
 * */

package chapter11.assingment;

import java.util.Date;

public class Employee extends Person {
	private String office;
	private double salary;
	private Date dateHired;

	public Employee(String name, String address, String phoneNumber, 
			String emailAddress, String office, double salary) {
		super(name,address, phoneNumber, emailAddress);
		this.office = office;
		this.salary = salary;
		this.dateHired = new Date();
	}

	/**
	 * @return the office
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the dateHired
	 */
	public Date getDateHired() {
		return dateHired;
	}

	/**
	 * @param dateHired the dateHired to set
	 */
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}
	
	public double getEmployeeBonus() {
		return this.salary + 0.5 * this.salary;
	}
	
	public double getTotalPay() {
		return this.salary + getEmployeeBonus();
	}
	
	@Override
	public String toString() {
		return (super.toString() 
				+ " Employee [office=" + office
				+ ", the salary is " + salary
				+ ", the dateHired is " + dateHired
				);
	}
}