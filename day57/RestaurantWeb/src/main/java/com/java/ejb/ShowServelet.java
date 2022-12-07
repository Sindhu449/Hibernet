package com.java.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServelet
 */
@WebServlet("/ShowServelet")
public class ShowServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RestaurantBeanRemote service=null;
		PrintWriter out=response.getWriter();
		
		try {
			service=(RestaurantBeanRemote) new InitialContext().lookup("RestaurantBean/remote");
			List<Restaurant> rList=service.showRestaurantBean();
			out.println("<table border=1");
			 out.println("<tr><th>Restaurant Id</th>"
			 		+ "<th> Restaurant name</th>"
			 		+ "<th>City</th>"
			 		+ "<th>state</th>"
			 		+ "<th>Pincode</th>"
			 		+ "<th>Email</th>"
			 		+ "<th>Username</th>"
			 		+ "<th>Password</th>"
			 		+ "</tr>");
			for (Restaurant restaurant : rList) {
				
		
	out.println("<tr><td>"+restaurant.getRest_id()
        + "</td><td>"+restaurant.getRest_name()+"</td>"
        		+ "<td>"+restaurant.getCity()+"</td>"
        				+ "<td>"+restaurant.getState()
		+"</td><td>"+restaurant.getPincode()+"</td>"
				+ "<td>"+restaurant.getRest_email()+"</td>"
						+ "<td>"+restaurant.getRest_userName()+"</td>"
								+ "<td>"+restaurant.getRest_password()+"</td></tr>");
				
			}out.println("</table>"); 
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
