
import java.sql.*;
import java.util.Scanner;

public class ResumeRunner {
	  static Scanner sc=new Scanner(System.in);
		public static void main(String[] args) {
           

			
				
				
				//1 get a connection
				//Connnection mycon=DriverManager.getConnection(url, user, password)
				//2 creae a statment
				//3 Execute sql query
				//4 process the result set
			ResumeDefinition  person=new ResumeDefinition ();
			Job person1=new Job();
			
			System.out.println("enter your full name");
			String name=sc.nextLine();
			person.setName(name);
			System.out.println("enter email");
			String email=sc.nextLine();
			person.setEmail(email);
			person.setEducationn(displayEducation());

			
			

			
			person.setWorkExperience(person1.addJobs());
			person.setSkill(person1.addSkills());
			System.out.println(person.getName());
			System.out.println(person.getEmail()+"\n");
			System.out.println("EDUCATION");
			System.out.println("________________");
			System.out.println(person.getEducationn());
			System.out.println("WORK EXPERIENCE");
			System.out.println("________________\n");
			System.out.println(person.getWorkExperience());
			System.out.println("Skills");
			System.out.println("________");
			System.out.println(person.getSkill());
			/*}catch(Exception e) { 
				e.printStackTrace();
				
			}*/
		}

		
		public static String displayEducation()
		{  
			String alleducation="";
			boolean more=false;
			while(!more)
			{  

			
			System.out.println("Enter educational achievments/degree and In what feild of study you graduated:\n Use this format:Bsc.in Computer science");
			String inputz=sc.nextLine();
			if(inputz.equalsIgnoreCase("no"))
			{   
				inputz="" ;
				more=true;
				break;
			}
			String degree=inputz;

			System.out.println("From which university you Graduated?");
			String university=sc.nextLine();
			System.out.println("When did you Graduated?");
			String graduated=sc.nextLine();
			System.out.println("more Educational history? If you are done, type NO");

			
			alleducation=alleducation+degree+"\n"+university+","+" "+graduated+"\n";
			}
			return alleducation;
		}
	}
