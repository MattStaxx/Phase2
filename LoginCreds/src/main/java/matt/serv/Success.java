package matt.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class Success extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public Success() {
    	
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
        out.println("<html><body>");
		out.println("<center>Registration Successful</center></br>");
		out.println("<center><html><body></center></br>");
		out.println("<center><a href=\"index.jsp\">Back to Registration Page</a></center></br>");
		out.println("<center><a href=\"index.jsp\">Proceed to Login Page</a></center></br>");
        out.println("</body></html>");
	}
}
