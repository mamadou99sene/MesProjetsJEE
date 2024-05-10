package momo.controleur.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import momo.model.Appartement;
import momo.model.Connect;

/**
 * Servlet implementation class SevletUsers
 */
@WebServlet("/users")
public class SevletUsers extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public SevletUsers() 
    {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		ArrayList<Appartement> appartement=new ArrayList<Appartement>();
		Connect connexion=new Connect();
		appartement=connexion.afficher();
		for(int i=0;i<appartement.size();i++)
		{
			int idApp=appartement.get(i).getidApp();
			 request.setAttribute("id", idApp);
			String libelle=appartement.get(i).getLibelle();
			request.setAttribute("libelle",libelle);
			String nom=appartement.get(i).getNomImmeuble();
			request.setAttribute("nom_app", nom);
			double prix=appartement.get(i).getPrix();
			request.setAttribute("prix", prix);
			String ville=appartement.get(i).getVille();
			request.setAttribute("ville",ville);
			String quartier=appartement.get(i).getQuartier();
			request.setAttribute("quartier", quartier);
			String type=appartement.get(i).getType();
			request.setAttribute("type", type);
			this.getServletContext().getRequestDispatcher("/users/index.jsp").include(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		//this.getServletContext().getRequestDispatcher("/accueil.jsp").include(request, response);
	}

}
