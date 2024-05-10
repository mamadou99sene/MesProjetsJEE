package bdbeans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import bdbeans.Produit;
import bdbeans.ProduitHome;


@ManagedBean
@SessionScoped
public class ProduitBean {
	private Produit produit;
	 
	public Produit getPersonnes() {
		return produit;
	}

	public void setPersonnes(Produit produit) {
		this.produit = produit;
	}
	public ProduitBean()
	{
		this.produit=new Produit();
	}
	
	public void ajouterProduit()
	{
		String numero=this.produit.getNumero();
		String libelle=this.produit.getLibelle();
		double prix=this.produit.getPrix();
		new ProduitHome().persist(produit);
	}
}
