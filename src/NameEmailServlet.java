

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
		
	     HttpSession session = request.getSession();
	     String nextURL = "/Education_1.jsp";
	 try{ 
	    	 
	    
		 String fullName = request.getParameter("FullName");
		 String email = request.getParameter("Email");
		
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
        }

	}
}
