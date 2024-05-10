package licence;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/mapage")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		if(login==null&&password==null)
		{
			login="";
			password="";
		}
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\'ISO-8859-1\'>");
		out.println("<title>Insert title here</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style.css'/>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p>ceci est ma premiere page jee</p>");
		out.print("<form method='post' action=''>");
		out.print("<label for 'login'>LOGIN<input type='text' name='login' id='login' value='"+login+"'/></label>");
		out.print("<label for 'password'>Password<input type='password' name='password' id='password' value='"+password+"'/></label>");
		out.print("<label for 'submit'><input type='submit' name='submit' id='submit' value='Envoyer'/></label>");
		out.print("</body>");
		out.print("</html>");
		out.print("");
		if(login.equals("momo"))
		{
			
		}
		else
		{
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=null;
		System.out.println("Entre doPost ");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		if(login.equals("Senemomo@")&&password.equals("1905"))
		{
		response.setContentType("text/html");
				try
				{
				 out=response.getWriter();	
				 out.println("Bienvenue dans notre site");
				}catch(Exception e)
				{
					
				}	
		}
		else
		{
			doGet(request, response);	
		}
		
	}

}
