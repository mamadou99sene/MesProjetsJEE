package momo.controleur;

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
import momo.model.Reservation;
import momo.model.User;


@WebServlet("/les_reservations")
public class Les_reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Les_reservations() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		ArrayList<Reservation> reservation=new ArrayList<Reservation>();
		Connect connexion=new Connect();
		reservation=connexion.my_reservations();
		User user=new User();
		Appartement appartement=new Appartement();
		for(int i=0;i<reservation.size();i++)
		{
			int id=reservation.get(i).getId();
			request.setAttribute("numero", id);
			request.setAttribute("heure", reservation.get(i).getHeure());
			user=reservation.get(i).getUser();
			String prenom=user.getPrenom();
			request.setAttribute("prenom_user",prenom);
			String nom=user.getNom();
			request.setAttribute("nom_user", nom);
			String telephone=user.getTelephone();
			request.setAttribute("telephone_user", telephone);
			appartement=reservation.get(i).getAppartement();
			request.setAttribute("adresse", appartement.getAdresse());
			this.getServletContext().getRequestDispatcher("/les_reservations.jsp").include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	}

}
