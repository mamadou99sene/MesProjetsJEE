package momo.controleur.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import momo.model.Appartement;
import momo.model.Connect;

/**
 * Servlet implementation class Details
 */
@WebServlet(name = "UsersDetails", urlPatterns = { "/users_details","*.php" })
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!request.getParameter("id").isEmpty())
		{
			int id_app=Integer.parseInt(request.getParameter("id"));
			Appartement appartement=new Appartement();
			Connect connexion=new Connect();
			appartement=connexion.get_details(id_app);
			request.setAttribute("libelle", appartement.getLibelle());
			request.setAttribute("nom", appartement.getNomImmeuble());
			request.setAttribute("prix",appartement.getPrix());
			request.setAttribute("nombre", appartement.getNbrePiece());
			request.setAttribute("superficie",appartement.getSuperficie());
			request.setAttribute("description", appartement.getDescription());
			request.setAttribute("ville", appartement.getVille());
			request.setAttribute("type", appartement.getType());
			HttpSession session=request.getSession();
			if(session.getValue("id_users")!=null)
			{
				HttpSession session_id_ap= request.getSession();
	            session_id_ap.setAttribute("sess_id_app", id_app);
				this.getServletContext().getRequestDispatcher("/users/users_details.jsp").include(request, response);
			}
			else
			{
				response.sendRedirect("/Appartements/authentification");
			}
            
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
