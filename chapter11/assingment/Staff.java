package chapter11.assingment;

public class Staff extends Employee {
	private String title;
//	private double totalStaffPay;
	

	
	
	public Staff(String name, String address, String phoneNumber, String emailAddress, 
			String office, double salary, String title) {
		super(name,address, phoneNumber, emailAddress, office, salary);
		this.title = title;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	@Override
	public double getEmployeeBonus() {
//		this.totalStaffPay = super.getTotalPay() + getSalary() * 0.075;
		
		return super.getEmployeeBonus() + 0.075 * getSalary();
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " Staff [title=" 
				+ title +  "]";
	}
	
}
