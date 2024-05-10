package momo.controleur.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import momo.model.Connect;
import momo.model.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/users/inscription.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!request.getParameter("prenom").isEmpty()&&!request.getParameter("nom").isEmpty()&&!request.getParameter("telephone").isEmpty()&&!request.getParameter("login").isEmpty()&&!request.getParameter("password").isEmpty())
		{
		   String prenom=request.getParameter("prenom");
		   String nom=request.getParameter("nom");
		   String telephone=request.getParameter("telephone");
		   String login=request.getParameter("login");
		   String password=request.getParameter("password");
		   User user=new User();
		   user.setPrenom(prenom);
		   user.setNom(nom);
		   user.setTelephone(telephone);
		   user.setLogin(login);
		   user.setPassword(password);
		   Connect connexion=new Connect();
		   Boolean insertion=connexion.insert_user(user);
		   if(insertion)
		   {
			   out.println("L'utilisateur "+prenom+" "+nom+" a été ajouté avec succes");
		   }
		}
	}

}
