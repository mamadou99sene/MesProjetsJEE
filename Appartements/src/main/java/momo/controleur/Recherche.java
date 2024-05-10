package momo.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import momo.model.Connect;
import momo.model.Appartement;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("rechercher")!=null)
		{
			String chaine=request.getParameter("rechercher");
			Connect connexion=new Connect();
			ArrayList<Appartement> appartement=new ArrayList<Appartement>();
			appartement=connexion.rechercher(chaine);
			if(!appartement.isEmpty())
			{
				for(int i=0;i<appartement.size();i++)
				{
					int idApp=appartement.get(i).getidApp();
					request.setAttribute("id", idApp);
					String libelle=appartement.get(i).getLibelle();
					request.setAttribute("libelle",libelle);
					String nom=appartement.get(i).getNomImmeuble();
					request.setAttribute("nom", nom);
					double prix=appartement.get(i).getPrix();
					request.setAttribute("prix", prix);
					String ville=appartement.get(i).getVille();
					request.setAttribute("ville",ville);
					String quartier=appartement.get(i).getQuartier();
					request.setAttribute("quartier", quartier);
					this.getServletContext().getRequestDispatcher("/recherche.jsp").include(request, response);
				}
				
			}
			else
			{
				response.sendRedirect("/Appartements/appartement");
			}
		}
	}

}
