package dhyan.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class BoundlessManagement
{
	BufferedReader bufferedReader;
	String line;
	String []employeeList;
	Employee techEmployee=new TechnicalTeam();
	Employee nonTechEmployee=new NonTechnicalTeam();
	TechnicalTeam technicalTeam=new TechnicalTeam();
	
//	NonTechnicalTeam nonTechnicalTeam=new NonTechnicalTeam();
	Manager manager=new Manager();
	SeniorEngineer seniorEngineer=new SeniorEngineer();
	Engineer engineer=new Engineer();
	ArrayList<Employee>employee_List=new ArrayList<Employee>();
	
	ArrayList<Manager> managerList=new ArrayList<Manager>();
	ArrayList<SeniorEngineer> seniorEngineerList =new ArrayList<SeniorEngineer>();
	ArrayList<Engineer> engineerList =new ArrayList<Engineer>();
	
    ArrayList<TechnicalTeam> techTeamList=new ArrayList<TechnicalTeam>();
    ArrayList<NonTechnicalTeam> nonTechTeamList=new ArrayList<NonTechnicalTeam>();
    
    ArrayList<Employee> streetMan=new ArrayList<Employee>();
    ArrayList<Employee> netMan=new ArrayList<Employee>();
    ArrayList<Employee> agnity=new ArrayList<Employee>();
    ArrayList<Employee> microsoftAffirmed=new ArrayList<Employee>();
    ArrayList<Employee> trilliant=new ArrayList<Employee>();
    
	ArrayList<Employee> organizationTeam =new ArrayList<Employee>();
	ArrayList<ArrayList<Employee>> organizingTeamsList=new ArrayList<ArrayList<Employee>>();
	
	HashMap<String,ArrayList<Employee>> projectsList=new HashMap<String,ArrayList<Employee>>();
//	HashMap<String,ArrayList<Employee>> employeesList=new HashMap<String,ArrayList<Employee>>();
	
	
	ArrayList<Employee>participationTeam=new ArrayList<Employee>();
	ArrayList<ArrayList<Employee>>participationTeamsList;
	int StreetManProjectMembersCount=0,NetManProjectMembersCount=0,AgnityProjectMembersCount=0,MicrosoftAffirmedProjectMembersCount=0,TrilliantProjectMembersCount=0;
	int memberCount, caseCount,employeeCheckCount;
	boolean checkResult = false ;
	@SuppressWarnings("null")
	public BoundlessManagement()
	{
		try
		{
			File file =new File("C:\\Users\\Administrator\\Documents\\BoundlessInputFile.txt");
		    bufferedReader=new BufferedReader(new FileReader(file));
			while((line=bufferedReader.readLine())!=null)
			{
				employeeList=line.split(",");
				if(line.startsWith("#"))
				{
					continue;
				}
				else if(employeeList.length==5)
				{
					if(!(employee_List.contains(employeeList[0])))
					{
						if (employeeList[2].equalsIgnoreCase("manager"))
						{
							techEmployee=new Manager(Integer.parseInt(employeeList[0]),employeeList[1],employeeList[2],employeeList[3],Boolean.parseBoolean(employeeList[4]));
							managerList.add((Manager) techEmployee);
							employee_List.add(techEmployee);
							addEmployeeToProjects(employeeList[3]);
//							createProjectMembercount(employeeList[3]);
							techTeamList.add((TechnicalTeam) techEmployee);
						}
						else if (employeeList[2].equalsIgnoreCase("senior engineer"))
						{
							techEmployee=new SeniorEngineer(Integer.parseInt(employeeList[0]),employeeList[1],employeeList[2],employeeList[3],Boolean.parseBoolean(employeeList[4]));
							seniorEngineerList.add((SeniorEngineer)techEmployee);
						    employee_List.add(techEmployee);
						    addEmployeeToProjects(employeeList[3]);
//							createProjectMembercount(employeeList[3]);
							techTeamList.add((TechnicalTeam) techEmployee);
						}
						else if(employeeList[2].equalsIgnoreCase("engineer"))
						{
							techEmployee=new Engineer(Integer.parseInt(employeeList[0]),employeeList[1],employeeList[2],employeeList[3],Boolean.parseBoolean(employeeList[4]));
							addEmployeeToProjects(employeeList[3]);
							engineerList.add((Engineer)techEmployee);
						    employee_List.add(techEmployee);
//							createProjectMembercount(employeeList[3]);
							techTeamList.add((TechnicalTeam) techEmployee);
						}
					}
				}
				else if(employeeList.length==4)
				{
					if(!(employee_List.contains(employeeList[0])))
					{
					    if(employeeList[2].equalsIgnoreCase("AdminTeam"))
						{
							nonTechEmployee=new NonTechnicalTeam(Integer.parseInt(employeeList[0]),employeeList[1],employeeList[2],Boolean.parseBoolean(employeeList[3]));
							employee_List.add(nonTechEmployee);
//							nonTechTeamList.add((NonTechnicalTeam) nonTechEmployee);
						}
						
					}
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("file is not found");
		}
		catch(IndexOutOfBoundsException indexException)
		{
			indexException.printStackTrace();
		}
	    catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public void addEmployeeToProjects(String project)
	{
		if(project.equalsIgnoreCase("streetman"))
		{
			streetMan.add(techEmployee);
		}
		else if(project.equalsIgnoreCase("netman"))
		{
			netMan.add(techEmployee);
		}
		else if(project.equalsIgnoreCase("agnity"))
		{
			agnity.add(techEmployee);
		}
		else if(project.equalsIgnoreCase("microsoftaffirmed"))
		{
			microsoftAffirmed.add(techEmployee);
		}
		else if(project.equalsIgnoreCase("trilliant"))
		{
			trilliant.add(techEmployee);
		}
	}
	public HashMap<String,ArrayList<Employee>> getProjectsTeamList()
	{
		projectsList.put("StreetMan", streetMan);
		projectsList.put("NetMan", netMan);
		projectsList.put("Aginty",agnity);
		projectsList.put("MicrosoftAffirmed",microsoftAffirmed);
		projectsList.put("Trilliant",trilliant);
		return projectsList;
	}
	public boolean checkProjectMembercount(String projectName)
	{
		if(projectName.equalsIgnoreCase("Streetman"))
		{
			if(StreetManProjectMembersCount>=2)
			{
				checkResult= false;
			}
			else
			{
				StreetManProjectMembersCount++;
				checkResult= true;
			}
		}
		else if(projectName.equalsIgnoreCase("NetMan"))
		{
			if(NetManProjectMembersCount>=2)
			{
				checkResult= false;
			}
			else
			{
				NetManProjectMembersCount++;
				checkResult= true;
			}
		}
		else if(projectName.equalsIgnoreCase("Agnity"))
		{
			if(AgnityProjectMembersCount>=2)
			{
				checkResult= false;
			}
			else
			{
				AgnityProjectMembersCount++;
				checkResult= true;
			}
		}
		else if(projectName.equalsIgnoreCase("MicrosoftAffirmed"))
		{
			if(MicrosoftAffirmedProjectMembersCount>=2)
			{
				checkResult= false;
			}
			else
			{
				MicrosoftAffirmedProjectMembersCount++;
				checkResult= true;
			}
			
		}
		else if(projectName.equalsIgnoreCase("Trilliant"))
		{
			if(TrilliantProjectMembersCount>=2)
			{
				checkResult= false;
			}
			else
			{
				TrilliantProjectMembersCount++;
				checkResult= true;
			}
		}
		return checkResult;
	}
	
	public ArrayList<Employee> getEmployeeDetails()
	{
		return employee_List;
	}
	
	public ArrayList<Employee> getAnEmployee(String designation,int employeeCount)
	{
		memberCount=0;
//		StreetManCheckCount=0;NetManCheckCount=0;AgnityCheckCount=0;MicrosoftAffirmedCheckCount=0;TrilliantCheckCount=0;
		while(true)
			{
			    Collections.shuffle(employee_List);
			    ArrayList<Employee> temp=new ArrayList<Employee>();
			    temp.add(employee_List.get(0));
					if(designation.equalsIgnoreCase(employee_List.get(0).getEmployeeDesignation())&&!(employee_List.get(0).isEmployeeStatus()))
					{
							if (organizingTeamsList.contains(temp)||(organizationTeam.contains(employee_List.get(0))))
							{
								continue;
							} 
							else
							{
								if(designation.equalsIgnoreCase("manager")||designation.equalsIgnoreCase("engineer")||designation.equalsIgnoreCase("senior engineer"))
								{
									for(TechnicalTeam technicalTeam: techTeamList)
									{
										if(technicalTeam.getEmployeeId()==(employee_List.get(0).getEmployeeId()))
										{
											checkResult= checkProjectMembercount(technicalTeam.getProjectName());
											break;
										}
								}
								}
								if(checkResult)
								{
									organizationTeam.add(employee_List.get(0));
									employee_List.get(0).setEmployeeStatus(true);
									memberCount++;
								}
								else if(designation.equals("adminteam"))
								{
									organizationTeam.add(employee_List.get(0));
									employee_List.get(0).setEmployeeStatus(true);
									memberCount++;
								}
								else
								{
									continue;
								}
							}	
					}
					
			    if(memberCount==employeeCount)
			    {
			    	break;
			    }
			    
			}
		return organizationTeam;	
	}
	public ArrayList<ArrayList<Employee>> organizingTeam(int managerCount,int seniorEngineerCount,int engineerCount ,int nonTechnicalTeam)
	{
		        	getAnEmployee("manager",managerCount);
				    getAnEmployee("senior Engineer", seniorEngineerCount);
					getAnEmployee("engineer", engineerCount);
					getAnEmployee("adminteam",nonTechnicalTeam);
					
					organizingTeamsList.add(organizationTeam);
				    organizationTeam=new ArrayList<Employee>();
		         return organizingTeamsList;
	}
	
	public ArrayList<ArrayList<Employee>> getTeam(int numberOfTeams)
	{
		participationTeamsList=new ArrayList<ArrayList<Employee>>(numberOfTeams);
		try {
			for(int i=0;i<employee_List.size();i++)
			{
				for(int j=0;j<numberOfTeams;j++)
				{
					if(i==0)
					{
						while(true)
						{
							Collections.shuffle(employee_List);
							if(!(employee_List.get(0).isEmployeeStatus()))
							{
								participationTeam.add(employee_List.get(0));
								participationTeamsList.add(participationTeam);
								participationTeam=new ArrayList<Employee>();
								employee_List.get(0).setEmployeeStatus(true);
								break;
							}
						}
					}
					else
					{
						employeeCheckCount=0;
						while(true)
						{
							Collections.shuffle(employee_List);
							employeeCheckCount++;
							if(!(employee_List.get(0).isEmployeeStatus()))
							{
								participationTeam.add(employee_List.get(0));
								participationTeamsList.get(j).add(employee_List.get(0));
								participationTeam=new ArrayList<Employee>();
								employee_List.get(0).setEmployeeStatus(true);
								break;
							}
							if(employeeCheckCount==employee_List.size())
							{
								break;
							}
								
						}
					}
					
				}
			}
			for(Employee emp:employee_List)
			{
				emp.setEmployeeStatus(false);
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		return participationTeamsList;
	}
}