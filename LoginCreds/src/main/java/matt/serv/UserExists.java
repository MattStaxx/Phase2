package matt.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserExists extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserExists() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	    response.setContentType("text/html");  
//		PrintWriter out = response.getWriter();
//		
//        out.println("<html><body background='sadBaby2.jpg'>");
//		out.println("<center>User Name Not Available...try again...</center></br>");
//		out.println("<center><html><body></center></br>");
//		out.println("<center><a href=\"index.jsp\">Back to Registration Page</a></center></br>");
//		out.println("<center><a href=\"index.jsp\">Proceed to Login Page</a></center></br>");
//        out.println("</body></html>");
//        
//        out.close();
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
