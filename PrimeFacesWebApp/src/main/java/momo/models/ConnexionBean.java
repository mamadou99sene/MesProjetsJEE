package momo.models;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import bdbeans.Personnes;
import bdbeans.PersonnesHome;


@ManagedBean
@SessionScoped
public class ConnexionBean {
	private Personnes personnes;
	 private boolean loggedIn=false;

	public Personnes getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Personnes personnes) {
		this.personnes = personnes;
	}
	public ConnexionBean()
	{
		this.personnes=new Personnes();
	}
	public boolean getLoggedIn() {
        return loggedIn;
    }
	public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
	public void verifierConnexion()
	{
		String email=this.personnes.getEmail();
		String password=this.personnes.getPassword();
		Personnes p=new PersonnesHome().connexion(password, email);
		if(p!=null) {
			ConnexionBean.this.personnes=p;
			this.loggedIn=true;
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			try {
				System.out.println("Connexion reussie");
				ec.redirect("./Bienvenu.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		    else {
		    	this.loggedIn=false;
		    	System.out.println("Erreur ! Email ou password incorrecte");
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email ou Mot de passe incorrect","");
				        FacesContext.getCurrentInstance().addMessage(null, msg);
			    }
	}
}
