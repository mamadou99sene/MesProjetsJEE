package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import .Najavax.injectmed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modeles.Personne;
import modeles.PersonneHome;
@Named
@SessionScoped 
public class ConnexionBean implements Serializable {
		private Personne utilisateur;
		private Personne nouvellepersonne;
		public Personne getNouvellepersonne() {
			return nouvellepersonne;
		}
		public void setNouvellepersonne(Personne nouvellepersonne) {
			this.nouvellepersonne = nouvellepersonne;
		}
		private Personne selectedpersonne;
		private List<Personne>listeUsers;
		//code de chargement des objets par le framework SPRING
		public static  ApplicationContext getContext() {
		     ApplicationContext  context= new ClassPathXmlApplicationContext ("SpringBeans.xml");
		     return context;
		}

public ConnexionBean() {
	utilisateur =(Personne)getContext ( ).getBean("pers");
	nouvellepersonne =(Personne)getContext ( ).getBean("pers");
	//this.utilisateur=new Personne();
	//this.nouvellepersonne=new Personne();
}
		public Personne getUtilisateur() {
			return utilisateur;
		}

		public void setUtilisateur(Personne utilisateur) {
			this.utilisateur = utilisateur;
		}
	public void verifierMotPasse() {
		try {   
			String l=this.utilisateur.getLogin();
			String m=this.utilisateur.getMotpasse();
			Personne x=new PersonneHome().verifierLoginMotPasse(l, m);
			if(x!=null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect("./vues/acceuil.jsf");
			}
		    else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou Mot de passe incorrect","");
				        FacesContext.getCurrentInstance().addMessage(null, msg);
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Personne> getListeUsers() {
		this.listeUsers=new PersonneHome().getAllPersonne();
		return listeUsers;
	}
	public void setListeUsers(List<Personne> listeUsers) {
		this.listeUsers = listeUsers;
	}
	@PostConstruct
	public void init() {
		this.nouvellepersonne=new Personne();
	}
	public void insererUtilisateur(){
		try{
			Personne p=new PersonneHome().verifierLogin(this.nouvellepersonne.getLogin());
			if(p==null) {
			new PersonneHome().persist(this.nouvellepersonne);
			this.nouvellepersonne=new Personne();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont bien sauvegardées", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
			else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Login existe deja", "");
		        FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
			}
			catch (RuntimeException re) {
				//log.error("Enregistrement Personne  failed...", re);
				throw re;
			}
		
		
	}

	public void modifierUtilisateur(){
		try{
			
			new PersonneHome().update(this.selectedpersonne);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont mises à jour", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
					}
			catch (RuntimeException re) {
				throw re;
			}
	}
	public void supprimerUtilisateur(){
		if(this.selectedpersonne!=null) {
	       new PersonneHome().delete(this.selectedpersonne);
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression de l'utilisateur "+selectedpersonne.getPrenom()+" "+selectedpersonne.getNom(), "");
	       FacesContext.getCurrentInstance().addMessage(null, msg); 
	       selectedpersonne=null;	
	       }
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de suppression" , "");
		       FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	public Personne getSelectedpersonne() {
		return selectedpersonne;
	}
	public void setSelectedpersonne(Personne selectedpersonne) {
		this.selectedpersonne = selectedpersonne;
	}


}
