package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.products.HibernateUtil;
import com.products.ProdDAO;
import com.products.Product;

// Servlet to gather user inputs from jsp, then send those inputs to the DAO, also allows for a query of the complete database for the user reference
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ProductServlet() {
    	
        super();
    }

    // doGet() method that builds a database representation to confirm application behavior
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();

            List<Product> list = session.createQuery("from Product", Product.class).list();
            
            session.close();
            
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html><body style=\"background-color:#EFF5FB;\">");
			out.println("<h2 style=\"text-align:center\">Pet Listings</h2>");
			out.println("<p style=\"text-align:center;\"><a href=\"index.jsp\">Back to Home Page</a></p><br/>");
			out.println("<table style=\"border:1px solid blue;padding:5px;border-spacing:28px;margin-left:auto;margin-right:auto\"><colgroup><col span=\"3\"></colgroup>");
 			out.println("<tr><th>Pet</th><th>Color</th><th>Price</th></tr>");
            for(Product p: list) {
            	out.println(String.valueOf("<tr><td>" + p.getName()) +
                		 	" </td>" + "<td> " + String.valueOf(p.getColor()) + " </td> " + " <td>" + p.getPrice() + "</td></tr>");
             }
             out.println("</body></html>");
         } catch (Exception ex) {
                 throw ex;
         }
    }

    // doPost() method retrieves user inputs from addProd.jsp then checks the price value for being a negative value
    // zeroCheck parses the String value to a double so that it can be compared to zero and used to prevent negative 
    // and zero values from being entered into the price column of the database table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		double zeroCheck = Double.parseDouble(price);
		HttpSession session = request.getSession(true);
        PrintWriter out = response.getWriter();
        
		try {	
			ProdDAO prodDAO = new ProdDAO();
			if(zeroCheck <= 0) {	
				response.setContentType("text/html");
				out.println("<html><body style='background-color:#EFF5FB;'>");
				out.println("<h2 style='text-align:center'>No zero or negative values allowed...</h2><br/>");
				out.println("<p style='text-align:center';><a href ='addProd.jsp'>click here to try again...</a></p>");
				out.println("</body></html>");
			} else {
			prodDAO.addProdDetails(name, color, price);
			response.sendRedirect("Success");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
} 