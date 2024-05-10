package momo.facto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Factoriel
 */
@WebServlet("/factoriel")
public class Factoriel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Factoriel() {
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
		//String nom=request.getParameter("name");
		//request.setAttribute("name", nom);
		this.getServletContext().getRequestDispatcher("/factoriel.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		response.setCharacterEncoding("UTF-8");
		String nombre=request.getParameter("nombre");
		int n=Integer.parseInt(nombre);
		int facto=1;
		for(int i=1;i<=n;i++)
		{
			facto=facto*i;
		}
		request.setAttribute("factoriel", facto);
		this.getServletContext().getRequestDispatcher("/factoriel.jsp").forward(request, response);
	}

}
