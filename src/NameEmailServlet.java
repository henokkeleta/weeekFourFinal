

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
 * Servlet implementation class NameEmailServlet
 */
@WebServlet("/NameEmailServlet")
public class NameEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection connect = null;
	     Statement statement = null;
	     PreparedStatement preparedStatement = null;
		 //doGet(request, response);
	     ResultSet resultSet = null;
		  String education0="";
		  String workExperience0="";
		  String skill0="";
	     HttpSession session = request.getSession();
	     String nextURL = "/Education_1.jsp";
	 try{ 
	    	 
	     
		 Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/ResumeMembers?user=root&password=password");
		 preparedStatement = connect.prepareStatement("insert into Resume(PersonId, FullName,Email,Education,WorkExperience,Skill)values(default, ?, ?,?,?,?)");
		 String fullName = request.getParameter("FullName");
		 String email = request.getParameter("Email");
		 preparedStatement.setString(1, fullName);
         preparedStatement.setString(2, email);
         preparedStatement.setString(3, education0);
         preparedStatement.setString(4, workExperience0);
         preparedStatement.setString(5, skill0);
         preparedStatement.executeUpdate();
         session.setAttribute("message1", fullName);
     	 session.setAttribute("message2", email);
     	 
     	 getServletContext().getRequestDispatcher(nextURL).forward(request, response);
	 
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
