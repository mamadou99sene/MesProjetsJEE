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
 * Servlet implementation class Suppression
 */
@WebServlet("/suppression")
public class Suppression extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppression() {
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
			HttpSession session=request.getSession();
			session.setAttribute("id_app",id);
			this.getServletContext().getRequestDispatcher("/suppression.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		if(request.getParameter("confirmer")!=null)
		{
			HttpSession session=request.getSession();
			int id_app=(int) session.getAttribute("id_app");
			Connect connexion=new Connect();
			Appartement appartement=new Appartement();
			out.println(id_app);
			Boolean suppression=connexion.supprimer(appartement,id_app);
			if(suppression)
			{
				out.println("L'appartement numero "+id_app+" a ete definitivement supprimé");
				
			}
			
		}
	}

}
