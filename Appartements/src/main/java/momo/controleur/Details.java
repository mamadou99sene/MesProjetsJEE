package momo.controleur;

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
@WebServlet("/details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Details() {
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
			int idapp=Integer.parseInt(request.getParameter("id"));
			Appartement appartement=new Appartement();
			Connect connexion=new Connect();
			appartement=connexion.get_details(idapp);
			request.setAttribute("libelle", appartement.getLibelle());
			request.setAttribute("prix", appartement.getPrix());
			request.setAttribute("description",appartement.getDescription());
			this.getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
			HttpSession session=request.getSession();
			session.setAttribute("nom", appartement.getNomImmeuble());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
