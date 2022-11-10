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
 * Servlet implementation class JdbcServelet
 */
@WebServlet("/JdbcServelet")
public class JdbcServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  EmployBeanRemote service = null;
		  PrintWriter out = response.getWriter();

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    try {
				service = (EmployBeanRemote)
						new InitialContext().lookup("EmployBean/remote");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    List<Employ> employList = null;
			try {
				employList = service.showEmployBean();
				out.println("<table border='3'>");
				out.println("<tr><th>Employ NO</th><th>Employ Name</th><th>Department</th><th>Designation</th><th>Basic</th></tr>");
				for (Employ employ : employList) {
					out.println("<tr><td>" +employ.getEmpno() +" </td> <td>" +employ.getName()  +"</td> "
							+ "<td>" +employ.getDept() +"</td> <td>" +employ.getDesig() +"</td> "
									+ "<td>" +employ.getBasic() +"</td></tr>");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    for (Employ employ : employList) {
				System.out.println(employ);
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
