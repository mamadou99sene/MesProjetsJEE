package momo.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import momo.model.Appartement;
import momo.model.Connect;
import momo.model.Image;



/**
 * Servlet implementation class ServeletAppartement
 */
@WebServlet("/appartement")
public class ServeletAppartement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletAppartement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/accueil.jsp").include(request, response);
		Connect connexion=new Connect();
		ArrayList<Appartement> appartement=new ArrayList<Appartement>();
		appartement=connexion.afficher();
		
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
			this.getServletContext().getRequestDispatcher("/affichage.jsp").include(request, response);
		}
		this.getServletContext().getRequestDispatcher("/form_recherche.jsp").include(request, response);
		this.getServletContext().getRequestDispatcher("/appartement.jsp").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");		
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
		//Part photo=request.getPart("photo");
		Connect connexion=new Connect();
		Appartement appartement=new Appartement();
		ArrayList<Image> image=new ArrayList<Image>();
		Image mon_image=new Image();
		//mon_image.setUrl(photo.toString());
		//image.add(mon_image);
		
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
		connexion.inserer(appartement);
		//this.getServletContext().getRequestDispatcher("/traitement.jsp").forward(request, response);
		doGet(request,response);
		out.println("Un appartement a ete ajouté dans votre base de donnees");
	}

}
