package examen;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculeServlet
 */
@WebServlet("/CalculeServlet")
public class CalculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculeServlet() {
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
		RequestDispatcher disp=request.getRequestDispatcher("/acceuil.jsp");
		disp.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		if(login.equals("TOTO")&&password.equals("TOTO123"))
		{
			String message="BIENVENUE TOTO";
			request.setAttribute("message", message);
			RequestDispatcher disp=request.getRequestDispatcher("/bienvenue.jsp");
			disp.forward(request, response);
		}
		else
		{
			out.println("ERREUR DE CONNEXION");
		}
	}

}
