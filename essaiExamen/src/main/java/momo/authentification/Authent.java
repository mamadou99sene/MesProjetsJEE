package momo.authentification;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authent
 */
@WebServlet("/authentification")
public class Authent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher disp=request.getRequestDispatcher("/authentification.jsp");
		disp.include(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		
		Connexion connexion=new Connexion();
		ArrayList<String> verification=connexion.authentification(login, password);
		out.println(verification.size());
		if(verification.size()>0)
		{
			out.println("Bienvenu "+verification.get(2));
		}
		else
		{
			out.println("Login ou mot de passe incorrect");
		}
		doGet(request, response);
	}

}
