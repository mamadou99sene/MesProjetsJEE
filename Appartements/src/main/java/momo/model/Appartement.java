package momo.model;

import java.util.ArrayList;

public class Appartement {
private int idApp;
private String libelle;
private String nomImmeuble;
private String type;
private double superficie;
private int nbrePiece;
private double prix;
private String description;
private String adresse;
private String quartier;
private String ville;
//private ArrayList<Image> image;
public int getidApp() {
	return idApp;
}
/*public ArrayList<Image> getImage() {
	return image;
}
public void setImage(ArrayList<Image> image) {
	this.image = image;
}*/
public String getLibelle() {
	return libelle;
}
public String getNomImmeuble() {
	return nomImmeuble;
}
public String getType() {
	return type;
}
public double getSuperficie() {
	return superficie;
}
public int getNbrePiece() {
	return nbrePiece;
}
public double getPrix() {
	return prix;
}
public String getDescription() {
	return description;
}
public String getAdresse() {
	return adresse;
}
public String getQuartier() {
	return quartier;
}
public String getVille() {
	return ville;
}
public void setiApp(int iApp) {
	this.idApp = iApp;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public void setNomImmeuble(String nomImmeuble) {
	this.nomImmeuble = nomImmeuble;
}
public void setType(String type) {
	this.type = type;
}
public void setSuperficie(double superficie) {
	this.superficie = superficie;
}
public void setNbrePiece(int nbrePiece) {
	this.nbrePiece = nbrePiece;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public void setDescription(String description) {
	this.description = description;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public void setQuartier(String quartier) {
	this.quartier = quartier;
}
public void setVille(String ville) {
	this.ville = ville;
}
}
