

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResumeServlet
 */
@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
		 Connection connect = null;
	     Statement statement = null;
	     PreparedStatement preparedStatement = null;
	     ResultSet resultSet = null;
	  
	     HttpSession session = request.getSession();
	     String nextURL = "/NameEmail.jsp";
	     
		try{ 

			 Class.forName("com.mysql.jdbc.Driver");
			 connect = DriverManager.getConnection("jdbc:mysql://localhost/ResumeMembers?user=root&password=password");
			 preparedStatement = connect.prepareStatement("insert into Resume(PersonId, FullName,Email,Education,WorkExperience,Skill)values(default, ?, ?,?,?,?)");
			//the next steps should be to mutate my previous resume class..it should fit in or 
			   // preparedStatement.setString(1, "PersonID");
			 
			 /**
			  * The following variables setted from the html form then get inserted in to the db for later use
			  */
			 
			 String fullName = request.getParameter("FullName");
			 String email = request.getParameter("Email");
			 String education = request.getParameter("Education");
			 String workExperience = request.getParameter("WorkExperience");
			 String skill = request.getParameter("Skill");
			// int personID = Integer.parseInt(resultSet.getString("PersonID"));
			
	            preparedStatement.setString(1, fullName);
	            preparedStatement.setString(2, email);
	            
	            preparedStatement.setString(3, education);
	            preparedStatement.setString(4, workExperience);
	            preparedStatement.setString(5, skill);
	            preparedStatement.executeUpdate();
	           //resultSet = preparedStatement.executeUpdate();
	          // writeResultSet(resultSet);
	          
	           // session.setAttribute("message", personID);
	        	session.setAttribute("message1", fullName);
	        	session.setAttribute("message2", email);
	        	session.setAttribute("message3", education);
	        	session.setAttribute("message4", workExperience);
	        	session.setAttribute("message5", skill);
	        	
	        	  
		}catch (Exception e) {
            try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        } finally {

		    
			
        	try
			{
				try {
					getServletContext().getRequestDispatcher(nextURL).forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	resultSet.close();
				preparedStatement.close();
				connect.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
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

	
		      ///the next code is for testing purpose
	            private void writeResultSet(ResultSet resultSet) throws SQLException {
	                // ResultSet is initially before the first data set
	                while (resultSet.next()) {
	                    // It is possible to get the columns via name
	                    // also possible to get the columns via the column number
	                    // which starts at 1
	                    // e.g. resultSet.getSTring(2);
	                    String fulN = resultSet.getString("FullName");
	                    String eml = resultSet.getString("Email");
	                    String educ = resultSet.getString("Education");
	                  
	                    String wok = resultSet.getString("WorkExperience");
	                    String skl = resultSet.getString("Skill");
	                    System.out.println("fulN: " + fulN);
	                    System.out.println("eml: " + eml);
	                    System.out.println("Edu: " + educ);
	                    System.out.println("workE: " + wok);
	                    System.out.println("Skill: " + skl);
	                }
	            }
	  

	        /*    // You need to close the resultSet
	            private void close() {
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
	            }*/

	        }
			
			//the test ends here 
	/*		
			
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  finally
	  {
			
			
			try
			{
				getServletContext().getRequestDispatcher(nextURL).forward(request, response);
				resultSet.close();
				preparedStatement.close();
				connect.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
            }
	  
			catch(ServletException e)
			{
				e.printStackTrace();
            }
	 
			
		}
	  
	}*/
		
		
		
		
		
		
		
		
		//doGet(request, response);
	//}


