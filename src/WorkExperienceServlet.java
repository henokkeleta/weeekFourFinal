

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WorkExperienceServlet
 */
@WebServlet("/WorkExperienceServlet")
public class WorkExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkExperienceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection connect = null;
	     Statement statement = null;
	     PreparedStatement preparedStatement = null;
		 //doGet(request, response);
	     ResultSet resultSet = null;
		  
	     HttpSession session = request.getSession();
	     String nextURL = "/Skill_1.jsp";
	     String experience="";
	 try{ 
	    	 
	     
		 Class.forName("com.mysql.jdbc.Driver");
		 connect = DriverManager.getConnection("jdbc:mysql://localhost/ResumeMembers?user=root&password=password");
		 preparedStatement = connect.prepareStatement("insert into Resume(WorkExperience)values(?)");
		 String job = request.getParameter("Job");
		 String Campany = request.getParameter("Company");
		 String yearStart=request.getParameter("StartYear");
		 String till=request.getParameter("Till");
		 String duty1=request.getParameter("Duty1");
		 String duty2=request.getParameter("Duty2");
		 String experience1=job+","+Campany+","+"/n"+yearStart+", "+till+"/n"+"Duty:"+duty1+"/n"+duty2;
		 
		 String more=request.getParameter("more");
		// String nextURL="/WorkExperience_1.jsp";
		 // experience= experience+","+major+","+year;
		 if(more.equalsIgnoreCase("yes"))
		 { 
		    nextURL= "/WorkExperience_1.jsp";
		    experience= experience+experience1;
		 }
		 else{ 
			 nextURL="/Skill_1.jsp";
		 }
		
		 preparedStatement.setString(1, experience);
		 preparedStatement.executeUpdate();
         session.setAttribute("message3", experience);
    	
    	 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
    	 //figure out about next url so as to go to the next url.
	 
	    } catch (Exception e) {
           try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
       } finally {
       	try {
               if (resultSet != null) {
                   resultSet.close();
               }

               if (statement != null) {
                   statement.close();
               }

               if (connect != null) {
                   connect.close();
               }
           } catch (Exception e) {

   }
}

	}
		
		
		
		
		
	}



