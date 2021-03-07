package com.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public ProductServlet() {
    	
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//request.getRequestDispatcher("prod/index.jsp").forward(request, response);
    	
    	try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            
            Session session = factory.openSession();

            List<Product> list = session.createQuery("from Product", Product.class).list();
            
            session.close();
            
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
             out.println("<b>Product Listing</b><br>");
             for(Product p: list) {
                 out.println(String.valueOf("Name: " + p.getName()) +
                             ", Color: " + String.valueOf(p.getColor()) + ", Price: " + Double.toString(p.getPrice()) + "<br>");
             }
             out.println("<a href=\"index.jsp\">Back to Add Products Page</a>");
             out.println("</body></html>");
         } catch (Exception ex) {
                 throw ex;
         }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		double price = Double.parseDouble(request.getParameter("price"));
		HttpSession session = request.getSession(true);
		try {		
			ProdDAO prodDAO = new ProdDAO();
			ProdDAO.addProdDetails(id, name, color, price);
			response.sendRedirect("Success");
		} catch(Exception e) {
			System.err.println("doPost");
			e.printStackTrace();
		}
	}
} //https://www.javawebtutor.com/articles/hibernate/hibernate_web_example.php
  //https://learningprogramming.net/java/jsp-servlet/update-data-to-database-with-hibernate-in-jsp-servlet/