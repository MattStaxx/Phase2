package matt.serv;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import matt.creds.HibernateUtil;
import matt.creds.UserDAO;

public class VerifyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public VerifyServlet() {
    	
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	    PrintWriter out = response.getWriter();  
		try {
            String name = request.getParameter("name");  
            String password = request.getParameter("password");  
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            
            if(UserDAO.verifyDetails(name, password)) {  
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                request.setAttribute("name", name);
                rd.forward(request, response); 
            }  
            else {    
                RequestDispatcher rd = request.getRequestDispatcher("loginError.jsp");  
                rd.include(request, response);
            }  
            out.close();
            session.close();  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
