package dhyan.com;

public class Employee
{
     private int employeeId;
     private String employeeName;
     private String employeeDesignation;
     private boolean employeeStatus;
     
     public Employee() {}
     
     
	public Employee(int employeeId, String employeeName, String employeeDesignation, boolean employeeStatus) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeStatus = employeeStatus;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public boolean isEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(boolean employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString()
	{
		String employee= employeeDesignation +"  "+employeeName   ;
		return employee;
	}
	
	
     
     
     
		
	
}
