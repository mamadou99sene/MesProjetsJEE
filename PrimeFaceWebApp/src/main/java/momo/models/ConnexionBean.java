package momo.models;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Personnes;

@ManagedBean
@SessionScoped
public class ConnexionBean {
	private Personnes personnes;

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
	public void verifierConnexion()
	{
		String email=this.personnes.getEmail();
		String password=this.personnes.getPassword();
		if(this.personnes!=null)
		{
			System.out.println("Connexion reussie");
		}
		else
		{
			System.out.println("Erreur ! Email ou password incorrecte");
		}
	}
}
