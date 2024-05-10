package login;

public class Personne 
{
 private int idPersonne;
 private String nom;
 private String password;
 public Personne(int idPersonne, String nom, String password, String prenom, String email) {
	this.idPersonne = idPersonne;
	this.nom = nom;
	this.password = password;
	this.prenom = prenom;
	this.email = email;
}
private String prenom;
 private String email;

public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getPassword() {
	return password;
}
public int getIdPersonne() {
	return idPersonne;
}
public String getNom() {
	return nom;
}
public String getEmail() {
	return email;
}
public void setIdPersonne(int idPersonne) {
	this.idPersonne = idPersonne;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setEmail(String email) {
	this.email = email;
}
public void setPassword(String password) {
	this.password = password;
}
}
