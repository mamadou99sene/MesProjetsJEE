package employe;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employe
 */
@WebServlet("/employe")
public class Employe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Statement stmt;
	private ResultSet res;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employe() {
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
		ConnectionInit connection=new ConnectionInit();
		
		this.getServletContext().getRequestDispatcher("/employe.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		this.getServletContext().getRequestDispatcher("/employe.jsp").include(request, response);
		String pr=request.getParameter("prenom");
		String nm=request.getParameter("nom");
		String sex=request.getParameter("sexe");
		String ad=request.getParameter("adresse");
		String pay=request.getParameter("pays");
		ConnectionInit connection=new ConnectionInit();
		Utilisateurs uti=new Utilisateurs();
		uti.setPrenom(request.getParameter("prenom"));
		if(request.getParameter("ajouter")!=null)
		{
		 uti.setPrenom(pr);
		 uti.setNom(nm);
		 uti.setSexe(sex);
		 uti.setAdresse(ad);
		 uti.setPays(pay);
		 connection.ajouter(uti);	
		 out.println(uti.getPrenom()+" "+uti.getNom()+" a ete bien inseré dans la base de donnees");
	    }
		if(request.getParameter("afficher")!=null)
		{
			ArrayList <Utilisateurs> liste=connection.afficher();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Numeros</th>");
			out.println("<th>Prenoms</th>");
			out.println("<th>Noms</th>");
			out.println("<th>Adresses</th>");
					
			for(int i=0;i<=liste.size();i++)
			{
				out.println("<tr>");
				out.print("<td>"+i+" "+"</td>"+" "+"<td>"+liste.get(i).getPrenom()+"</td>");
				out.println("<td>"+liste.get(i).getNom()+"</td>");
				out.println("<td>"+liste.get(i).getAdresse()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		if(request.getParameter("modifier")!=null)
		{
			Utilisateurs user=new Utilisateurs();
			user.setPrenom(pr);
			user.setNom(nm);
			user.setSexe(sex);
			connection.modifier(user);
			out.println(user.getPrenom()+" "+user.getNom()+" a ete modiefier dans la table");
		}

  }
}
