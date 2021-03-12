package matt.serv;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class Welcome extends HttpServlet {  

	private static final long serialVersionUID = 1L;

//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
//
//	    String n = request.getParameter("name");  
//	    response.setContentType("text/html");  
//	    PrintWriter out = response.getWriter();  
//	          
//        out.println("<html><body background='openVault.jpg'>");
//		out.println("<center>Registration Successful</center></br>");
//	    out.println("Welcome " + n); 
//		out.println("<center><html><body></center></br>");
//		out.println("<center><a href=\"index.jsp\">Back to Registration Page</a></center></br>");
//        out.println("</body></html>"); 
//	          
//	    out.close();  
//    }  

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		doGet(request, response);
	}
}	  