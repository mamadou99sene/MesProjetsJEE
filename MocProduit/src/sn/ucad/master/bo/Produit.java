package sn.ucad.master.bo;

import java.util.Objects;

public class Produit {
	
	private String referenc; 
	private String  designation;
	private double prix; 
	private int quantite;
	
	public Produit() {
		
	}

	
	public Produit(String referenc, String designation, double prix, int quantite) {
		super();
		this.referenc = referenc;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}


	public String getReferenc() {
		return referenc;
	}

	public void setReferenc(String referenc) {
		this.referenc = referenc;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	
	@Override
	public String toString() {
		return "Produit [referenc=" + referenc + ", designation=" + designation + ", prix=" + prix + ", quantite="
				+ quantite + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(designation, prix, quantite, referenc);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(designation, other.designation)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix) && quantite == other.quantite
				&& Objects.equals(referenc, other.referenc);
	}
	
	
}
