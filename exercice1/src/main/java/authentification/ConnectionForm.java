package authentification;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	private String resultat;
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public void verifier(HttpServletRequest req)
	{
		String log=req.getParameter("log");
		String pass=req.getParameter("pass");
		if(pass.equals(log+"123"))
		{
			this.resultat="Bienvenue dans notre page d'accueil";
		}
		else
		{
			this.resultat="Identifiants incorrects";
		}
		
	}

}
