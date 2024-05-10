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

/**
 * Servlet implementation class Reservation
 */
@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		if(session.getValue("sess_id_app")!=null&&session.getValue("id_users")!=null)
		{
			int id_app=(int)session.getValue("sess_id_app");
			int id_users=(int)session.getValue("id_users");
			String prenom=(String)session.getValue("prenom");
			String nom=(String)session.getValue("nom");
			Connect connexion=new Connect();
			boolean reservation=connexion.reserver(id_app, id_users);
			out.println(reservation);
			if(reservation)
			{
				response.sendRedirect("/Appartements/users_details?id="+id_app);
			}
			
		}
		else
		{
			response.sendRedirect("/Appartements/users");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	}

}
