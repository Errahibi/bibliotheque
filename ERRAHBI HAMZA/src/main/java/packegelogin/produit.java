package packegelogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class produit
 */
@WebServlet("/produit")
public class produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public produit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//acceptation non et motpass
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
	//database
		try { 
			//connecter
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("c","root","root");
			//acceder auxtable data
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from student where username='"+username+"' and passwor='"+password+"'");
			
			if (rs.next())
			{ //si le nom et mot de pess est vrai
				response.sendRedirect("Home.html");	
			}
			else {
				out.println("les donnees est inccorect!!!!!")	;		}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

}
