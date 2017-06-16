

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
		
		  
	     HttpSession session = request.getSession();
	     String nextURL = "/Skill_1.jsp";
	     String experience="";
	     String fullName0= (String) session.getAttribute("FullName");
	     String emil0=(String) session.getAttribute("Email");
		
		 String education0=(String) session.getAttribute("Education");
		 String skill0=(String) session.getAttribute("Skill");
	 try{ 
	    	 
	     
		 Class.forName("com.mysql.jdbc.Driver");
		
		 String job = request.getParameter("Job");
		 String Campany = request.getParameter("Company");
		 String yearStart=request.getParameter("StartYear");
		 String till=request.getParameter("Till");
		 String duty1=request.getParameter("Duty1");
		 String duty2=request.getParameter("Duty2");
		 String experience1=job+","+Campany+","+"/n"+yearStart+", "+till+"/n"+"Duty:"+duty1+"/n"+duty2;
		 
		 String more=request.getParameter("more");
		
		 if(more.equalsIgnoreCase("yes"))
		 { 
		    nextURL= "/WorkExperience_1.jsp";
		    experience= experience+experience1;
		 }
		 else{ 
			 experience=experience1;
			 nextURL="/Skill_1.jsp";
		 }
		
         session.setAttribute("message4", experience);
    	
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



