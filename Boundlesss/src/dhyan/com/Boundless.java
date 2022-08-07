package dhyan.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

public class Boundless 
{
//	Queue
	Scanner scanner=new Scanner(System.in);
	int managerCount,seniorEngineerCount,engineerCount,nonTechnicalTeam,teamsCount;
	public void startBoundless()
		{
		BoundlessManagement boundlessManagement=new BoundlessManagement();
			
			ArrayList<Employee> employee=new ArrayList<Employee>();
			ArrayList<Employee> organizingTeam= new ArrayList<Employee>();
			ArrayList<ArrayList<Employee>> participationTeams=new ArrayList<ArrayList<Employee>>();
			ArrayList<ArrayList<Employee>> organizationTeams_List=new ArrayList<ArrayList<Employee>>();
			
			int loop=0;
			int managerListSize=boundlessManagement.managerList.size();
			System.out.println("Welcome to BoundlessOrganization");
			
			while(true)
			{
				System.out.println("\nselect your choice\n1.total employee's list\n2.create a boundless team\n3.get all  organization teams list\n4.all projects list\n5.quit.");
				int choice=getAnInput();
				if(choice==1)
				{
					employee= boundlessManagement.getEmployeeDetails();
					for(Employee employeeList:employee)
					{
						System.out.println(employeeList);
					}
				}
				else if(choice==2)
				{
					while(true)
					{
						System.out.println("select your choice\n1.create organize and participation teams\n2.quit");
						int number=getAnInput();
						if(number==1)
						{
							System.out.println("enter details for organizing team");
							for(int i=loop;i<=loop;i++)
							{
								    if( managerListSize>0)
								    {
								    	System.out.println("enter the number of managers for organizing team ");
										managerCount=getAnInput();
										managerCount= checkListSize(managerListSize, managerCount, "managers");
										managerListSize-=managerCount;
								    }
									
									System.out.println("enter the number of senior engineers for organizing team ");
									seniorEngineerCount=getAnInput();
									seniorEngineerCount=checkListSize(boundlessManagement.seniorEngineerList.size(), seniorEngineerCount, "senior engineers");
									System.out.println("enter the number of engineers for organizing team ");
									engineerCount=getAnInput();
									engineerCount=checkListSize(boundlessManagement.engineerList.size(), engineerCount, "engineers");
									System.out.println("enter the number of non technical members for organizing team ");
									nonTechnicalTeam=getAnInput();
									organizingTeam=boundlessManagement.organizingTeam(managerCount,seniorEngineerCount,engineerCount,nonTechnicalTeam).get(i);
									System.out.println("organizing team created");	
							}
							loop++;
							System.out.println("enter details for participation teams");
							System.out.println("enter the number of teams you want create ");
							teamsCount=getAnInput();
							checkListSize(boundlessManagement.employee_List.size(), teamsCount, "employees");
							participationTeams=   boundlessManagement.getTeam(teamsCount);
							System.out.println("Organization Team Members:");
							for(Employee organizing_Team:organizingTeam)
							{
								System.out.println(organizing_Team);
							}
							System.out.println("Participating Teams:");
							int j = 0;
							for(ArrayList<Employee> participation_Teams:participationTeams)
							{
								System.out.println("Team-"+j+":");
								for(Employee teams:participation_Teams)
								{
									System.out.println(teams+"\t");
								}
								System.out.println();
								j++;
							}
						}
						else if(number==2)
						{
							break;
						}
						else
						{
							System.out.println("enter the your input from above choices only\n");
							continue;
						}
						
					}
				}
				else if(choice==3)
				{
					organizationTeams_List=boundlessManagement.organizingTeamsList;
					if(organizationTeams_List.isEmpty())
					{
						System.out.println("no boundlessteams are created");
					}
					else
					{
						for(ArrayList<Employee> organizationTeam_List:organizationTeams_List)
						{
							System.out.println(organizationTeam_List);
						}
						
					}
				}
				else if(choice==4)
				{
					HashMap<String, ArrayList<Employee>> projectsList=boundlessManagement.getProjectsTeamList();
					projectsList.forEach((k,v) -> System.out.println("project name : "+ k+"->"+v));
				}
				else if(choice==5)
				{
					break;
				}
				else
				{
					System.out.println("enter the your input from above choices only\n");
					continue;
				}
				
			}
		}
         public int checkListSize(int listSize,int memberCount,String employeerole)
         {
        	 while(true)
				{
					if(memberCount>listSize)
					{
						System.out.println("you entered the input more than " +employeerole+" we have\n"+employeerole+" count :"+listSize+"\nenter input again");
						memberCount=getAnInput();
					}
					else if(memberCount<=listSize)
						break;
				}
        	 return memberCount;
        	
         }
      public int getAnInput()
			{
			    int readChoice = 0;
			    try
			    {
			    	while(true)
			    	{
			    	  readChoice= scanner.nextInt();
						break;
			    	}
			    }
			    catch(InputMismatchException inputMisMatchException)
				{
					System.out.println("This is an invalid input,please! enter a vallid input");	
					scanner=new Scanner(System.in);
//					inputMisMatchException.printStackTrace();
				}
				catch (Exception e)
				{
                  	System.out.println("This is an invalid input,please! enter a vallid input");	
                  	scanner=new Scanner(System.in);
					e.printStackTrace();
				}
					return readChoice;
				}
				
	public static void main(String arg[]) 
	{
	
			Boundless boundless=new Boundless();
			boundless.startBoundless();
     }
}
		

//							for(int k=1;k<=teamsCount;k++)
//							{
//								System.out.print("Team "+k+"\t\t");
//							}
//							System.out.println();
//							for(int i=0;i<participationTeams.size();i++)
//							{
//								
//								ArrayList<Employee> participation_Team = participationTeams.get(i);
//								System.out.print(participation_Team.get(i).getEmployeeName()+"\t");
//							}
//							for(int i=0;i<participationTeams.get(j).size();i++)
//							{
//								for(j=0;j<participationTeams.size();j++)
//								{
//									String n=participationTeams.get(j).get(i).getEmployeeName();
//									if(!(n.equalsIgnoreCase(null)))
//									System.out.print(participationTeams.get(j).get(i).getEmployeeName()+"\t");
//								}
//								System.out.println();
//							}