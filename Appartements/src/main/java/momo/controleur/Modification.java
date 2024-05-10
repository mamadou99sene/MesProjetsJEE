package momo.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import momo.model.Appartement;
import momo.model.Connect;
import momo.model.Image;

/**
 * Servlet implementation class Modification
 */
@WebServlet("/modification")
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification() {
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
		if(request.getParameter("id")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			Connect connexion=new Connect();
			Appartement appartement=new Appartement();
			appartement=connexion.selectionner(id);
			request.setAttribute("libelle", appartement.getLibelle());
			request.setAttribute("nom", appartement.getNomImmeuble());
			request.setAttribute("prix", appartement.getPrix());
			request.setAttribute("description", appartement.getDescription());
			request.setAttribute("ville", appartement.getVille());
			request.setAttribute("quartier", appartement.getQuartier());
			HttpSession session= request.getSession();
			session.setAttribute("id_app", id);
			this.getServletContext().getRequestDispatcher("/modification.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		int id_app=(int) session.getAttribute("id_app");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String libelle=request.getParameter("libelle");
		String nom=request.getParameter("nom");
		String type=request.getParameter("type");
		double superficie=Double.parseDouble(request.getParameter("superficie"));
		int nombre=Integer.parseInt(request.getParameter("nombre"));
		double prix=Double.parseDouble(request.getParameter("prix"));
		String description=request.getParameter("description");
		String adresse=request.getParameter("adresse");
		String quartier=request.getParameter("quartier");
		String ville=request.getParameter("ville");
		Connect connexion=new Connect();
		Appartement appartement=new Appartement();
		appartement.setLibelle(libelle);
		appartement.setNomImmeuble(nom);
		appartement.setType(type);
		appartement.setSuperficie(superficie);
		appartement.setNbrePiece(nombre);
		appartement.setPrix(prix);
		appartement.setDescription(description);
		appartement.setAdresse(adresse);
		appartement.setQuartier(quartier);
		appartement.setVille(ville);
		boolean modification=connexion.modifier(appartement,id_app);
		if(modification)
		{
			out.println("L'appartement numero "+id_app+" a ete modifié avec succes");
		}
	}

}
