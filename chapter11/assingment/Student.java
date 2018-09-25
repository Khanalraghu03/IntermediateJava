package chapter11.assingment;

public class Student extends Person {
	private String classStatus;
	
	public Student() {}
	
	public Student(String name, String address, String phoneNumber,
			String emailAddress, String cLASS_STATUS) {
		super(name,address,phoneNumber,emailAddress);
		this.classStatus = cLASS_STATUS;
	}
	
	
	/**
	 * @return the classStatus
	 */
	public String getClassStatus() {
		return classStatus;
	}

	/**
	 * @param classStatus the classStatus to set
	 */
	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}

	
	
	
	
	
	@Override
	public String toString() {
		return super.toString() + " Student [classStatus=" + classStatus + "]";
	}
	
	
}
