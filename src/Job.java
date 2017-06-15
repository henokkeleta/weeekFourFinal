
import java.util.Scanner;
public class Job {
	static Scanner sc=new Scanner(System.in);
	private String workExperience;
	private String skill;

	



	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getWorkExperience() {

		return workExperience;
	}

	public Job(String workExperience) {
		super();
		this.workExperience = workExperience;
	}

	public Job() {
		// TODO Auto-generated constructor stub
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience=workExperience;

		
	}
	public String addSkills()
	{
	String skil="";
	String input="";
	String allSkills="";
	boolean done=false;
	while(!done)
	{
		if(skil.equalsIgnoreCase("no"))
		{   
			skil="" ;
			done=true;
			break;
		}

		
		System.out.println("Enter your skills");
		input=sc.nextLine();
		allSkills=allSkills+"-"+input+"\n";
		System.out.println("more skills? If u are done type yes or no");
		skil=sc.nextLine();
	}
	return allSkills;	
	}
	public String addJobs() {

		String allStrings="";

		boolean done =false;

		while(!done)
		{   

			String duties="";
			System.out.println("Enter your work experience,if u are done type no");

			String input0=sc.nextLine();

			if(input0.equalsIgnoreCase("no"))
			{ 
				done=true;
				break;
			}

			boolean done2=false;
			String companyName="";
			while(!done2)
			{  
				System.out.println("Enter the campany name:if you are done type no");
				String inputz=sc.nextLine();
				if(inputz.equalsIgnoreCase("no"))
				{   
					inputz="" ;
					done2=true;
					break;
				}
				String input1=inputz;


				System.out.println("Stared when?");
				String start =sc.nextLine();
				System.out.println("Till when?");
				String end =sc.nextLine();

				String times=start+"-"+end;

				companyName=companyName+" "+input1+","+times+" ";

				System.out.println("more campnies?");

			}

			boolean done1 =false;
			int i=1;
			while(!done1)
			{ 

				System.out.println("Enter your duty here,if you are done type no");

				String inputz=sc.nextLine();
				if(inputz.equalsIgnoreCase("no"))
				{   
					inputz="" ;
					done2=true;
					break;
				}
				String input2=inputz;

				duties= duties+"    - "+"Duty"+i+","+ input2+"\n";
				i++;
				System.out.println("more duty?");
			}
			allStrings =allStrings+input0+"\n"+companyName+"\n"+duties;

			System.out.println("more experience on other fields?");
		}
		return allStrings;  
	}


}
