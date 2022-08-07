package dhyan.com;

public class NonTechnicalTeam extends Employee
{
	public NonTechnicalTeam(int employeeId, String employeeName, String employeeDesignation, boolean employeeStatus)
	{
		super(employeeId, employeeName, employeeDesignation, employeeStatus);
		
		
	}

	public NonTechnicalTeam() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return  super.toString() ;
	}
	
	

}
