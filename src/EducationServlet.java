

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
		
		  
	     HttpSession session = request.getSession();
	     String nextURL = "/WorkExperience_1.jsp";
	     String education="";
	    
	 try{ 
	    	 
	    
		 String university = request.getParameter("University");
		 String major = request.getParameter("Major");
		 String year=request.getParameter("GrauateYear");
		 String more=request.getParameter("more");
		 // nextUrl="/WorkExperience_1.jsp";
		 String education1=university+","+major+","+year;
		 if(more.equalsIgnoreCase("yes"))
		 { 
		    nextURL= "/Education_1.jsp";
		    education= education+"  "+education1;
		 }
		 else{ 
			 nextURL="/WorkExperience_1.jsp";
			 education=education1;
		 }
		
		
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
       } 
	}


	
		
		
		
		
		
	}


