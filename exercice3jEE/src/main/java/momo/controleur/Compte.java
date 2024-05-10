package momo.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import momo.model.*;

/**
 * Servlet implementation class Compte
 */
@WebServlet("/compte")
public class Compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Compte() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String numero=request.getParameter("numero");
		
		ArrayList<Personnel> les_client=new ArrayList<Personnel>();
		Personnel personnel=new Personnel();
		Connect connect=new Connect();
		connect.se_connecter();
		les_client=connect.verification(personnel,numero);
		if(les_client.size()>0)
		{
			HttpSession session=request.getSession();
			request.setAttribute("session", session);
			
			
			String adresse=request.getRemoteHost();
			request.setAttribute("adreeseIP", adresse);
			
			
			Cookie cookie=new Cookie("nomc", numero);
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
			if(cookie!=null)
			{
				Cookie tab[]=request.getCookies();
				for(Cookie cok:tab)
				{
					if(cok.getName().equals("nomc"))
					{
						
						request.setAttribute("cookie", cok.getValue());
					}
				}
			}
			//out.println("bienvenu "+les_client.get(0).getPrenom()+" votre solde est de "+les_client.get(0).getSolde());
			request.setAttribute("prenom", les_client.get(0).getPrenom());
			request.setAttribute("solde", les_client.get(0).getSolde());
			this.getServletContext().getRequestDispatcher("/compte.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect("/exercice3jEE/index");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String numero=(String)request.getAttribute("num_client");
		out.println("Compte dopost"+numero);
	}

}
