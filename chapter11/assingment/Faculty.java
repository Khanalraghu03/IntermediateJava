/*
 * @author: Raghu Khanal
 * 
 * 
 * 
 * */

package chapter11.assingment;

public class Faculty extends Employee{
	private String officeHours;
	private String rank;

	public Faculty(String name, String address,String phoneNumber, String emailAddress,
			String office, double salary, String officeHours, String rank) {
		super(name,address,phoneNumber,emailAddress,office,salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	/**
	 * @return the officeHours
	 */
	public String getOfficeHours() {
		return officeHours;
	}

	/**
	 * @param officeHours the officeHours to set
	 */
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public double getEmployeeBonus () {

		return super.getEmployeeBonus() + 0.045 * getSalary();
	}

	@Override
	public String toString() {
		return super.toString() + " Faculty [officeHours=" 
				+ officeHours + ", rank=" + rank + "]";
	}
	
}