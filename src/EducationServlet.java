

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
 * Servlet implementation class EducationServlet
 */
@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	     String nextURL = "/WorkExperience_1.jsp";
	     String education="";
	     String fullName0= (String) session.getAttribute("FullName");
	     String emil0=(String) session.getAttribute("Email");
		 String workExperience0=(String) session.getAttribute("WorkExperience");
		  String skill0=(String) session.getAttribute("Skill");
	 try{ 
	    	 
	     
		 Class.forName("com.mysql.jdbc.Driver");
		 connect = DriverManager.getConnection("jdbc:mysql://localhost/ResumeMembers?user=root&password=password");
		 preparedStatement = connect.prepareStatement("insert into Resume(PersonId, FullName,Email,Education,WorkExperience,Skill)values(default, ?, ?,?,?,?)");
		 String university = request.getParameter("University");
		 String major = request.getParameter("Major");
		 String year=request.getParameter("GrauateYear");
		 String more=request.getParameter("more");
		 // nextUrl="/WorkExperience_1.jsp";
		 String education1=university+","+major+","+year;
		 if(more.equalsIgnoreCase("yes"))
		 { 
		    nextURL= "/Education_1.jsp";
		    education= education+"/n "+education1;
		 }
		 else{ 
			 nextURL="/WorkExperience_1.jsp";
			 
		 }
		
		 preparedStatement.setString(1, fullName0);
		 preparedStatement.setString(2,emil0);
		 preparedStatement.setString(3, education);
        preparedStatement.setString(4, workExperience0);
        preparedStatement.setString(5, skill0);
		 preparedStatement.executeUpdate();
         session.setAttribute("message3", education);
    	
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


	private String getsession(String string) {
		
		return null;
	}
		
		
		
		
		
	}


