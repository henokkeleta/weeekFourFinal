

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
 * Servlet implementation class SkillServlet
 */
@WebServlet("/SkillServlet")
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkillServlet() {
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
	     String nextURL = "/OutPut_1.jsp";
	     String Skill="";
	 try{ 
	    	 
	     
		 Class.forName("com.mysql.jdbc.Driver");
		 connect = DriverManager.getConnection("jdbc:mysql://localhost/ResumeMembers?user=root&password=password");
		 preparedStatement = connect.prepareStatement("insert into Resume(Skill)values(?)");
		 String Sk1 = request.getParameter("Skill1");
		 String pr1 = request.getParameter("Proficiencey1");
		 String Sk2 = request.getParameter("Skill2");
		 String pr2 = request.getParameter("Proficiencey2");
		 String Sk3 = request.getParameter("Skill3");
		 String pr3 = request.getParameter("Proficiencey3");
		 String Sk4 = request.getParameter("Skill4");
		 String pr4 = request.getParameter("Proficiencey4");
		 String Sk5 = request.getParameter("Skill5");
		 String pr5 = request.getParameter("Proficiencey5");
		 String Sk6 = request.getParameter("Skill6");
		 String pr6 = request.getParameter("Proficiencey6");
		 String Sk7 = request.getParameter("Skill7");
		 String pr7 = request.getParameter("Proficiencey7");
		 String Sk8 = request.getParameter("Skill8");
		 String pr8 = request.getParameter("Proficiencey8");
		 String Sk9 = request.getParameter("Skill9");
		 String pr9 = request.getParameter("Proficiencey9");
		 String Sk10 = request.getParameter("Skill10");
		 String pr10= request.getParameter("Proficiencey10");
		 Skill=Sk1+","+"profficency"+" "+pr1+"\n"+Sk2+","+"profficency"+" "+pr2+"\n"+Sk3+","+"profficency"+" "+pr3+"\n"+Sk4+","+"profficency"+" "+pr4+"\n"+
				 Sk5+","+"profficency"+" "+pr5+"\n"+Sk6+","+"profficency"+" "+pr6+"\n"+Sk7+","+"profficency"+" "+pr7+"\n"+Sk8+","+"profficency"+" "+pr8+"\n"+
				 Sk9+","+"profficency"+" "+pr9+"\n"+Sk10+","+"profficency"+" "+pr10;
		
		// String nextURL="/OutPut_1.jsp";
		
		 
		
		 preparedStatement.setString(1, Skill);
		 preparedStatement.executeUpdate();
         session.setAttribute("message5", Skill);
    	
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


