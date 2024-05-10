package momo.model;

public class Personnel
{
	private String numero;
	private String prenom;
	private String nom;
	private char sexe;
	private String adresse;
	private String pays;
	private double solde;
	private int decouvert;
	public String getNumero() {
		return numero;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getNom() {
		return nom;
	}
	public char getSexe() {
		return sexe;
	}
	public String getAdresse() {
		return adresse;
	}
	public String getPays() {
		return pays;
	}
	public double getSolde() {
		return solde;
	}
	public int getDecouvert() {
		return decouvert;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}
}
