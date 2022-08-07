package dhyan.com;

public class TechnicalTeam  extends Employee
{
	private String projectName;
	public TechnicalTeam(int employeeId, String employeeName, String employeeDesignation,String projectName, boolean employeeStatus)
	{
		super(employeeId, employeeName, employeeDesignation, employeeStatus);
		this.projectName=projectName;
	}
	
	public TechnicalTeam() {}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " ("+projectName+"), ";
	}
	

	
}
