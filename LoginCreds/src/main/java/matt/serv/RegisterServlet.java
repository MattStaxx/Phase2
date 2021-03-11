package matt.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import matt.creds.HibernateUtil;
import matt.creds.UserDAO;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


    public RegisterServlet() {
    	
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession(); 
		try {		
			UserDAO userDAO = new UserDAO();
			if(userDAO.checkForUser(name) == true) {
				userDAO.addUserDetails(name, password);
	            RequestDispatcher rd = request.getRequestDispatcher("Success");  
	        	rd.forward(request,response);
			} else {
                RequestDispatcher rd = request.getRequestDispatcher("UserExists");  
            	rd.forward(request,response);  
			}  
            session.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}