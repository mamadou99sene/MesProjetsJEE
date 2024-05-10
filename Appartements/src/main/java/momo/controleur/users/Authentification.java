package momo.controleur.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import momo.model.Connect;
import momo.model.User;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Authentification() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/users/authentification.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!request.getParameter("login").isEmpty()&&!request.getParameter("password").isEmpty())
		{
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			Connect connexion=new Connect();
			User user=new User();
			user=connexion.authentification(login, password);
			if(login.equals(user.getLogin())&&password.equals(user.getPassword()))
			{
				HttpSession prenom=request.getSession();
				HttpSession nom=request.getSession();
				HttpSession id_user=request.getSession();
				id_user.setMaxInactiveInterval(60);
				prenom.setAttribute("prenom", user.getPrenom());
				nom.setAttribute("nom", user.getNom());
				id_user.setAttribute("id_users", user.getId());
				response.sendRedirect("/Appartements/users");
				
			}
			else
			{
				response.sendRedirect("/Appartements/authentification");
			}
		}
	}

}
