package momo.model;

public class User 
{
  private int id;
  private String prenom;
  private String nom;
  private String telephone;
  private String login;
  private String password;
public int getId() {
	return id;
}
public String getPrenom() {
	return prenom;
}
public String getNom() {
	return nom;
}
public String getTelephone() {
	return telephone;
}
public String getLogin() {
	return login;
}
public String getPassword() {
	return password;
}
public void setId(int id) {
	this.id = id;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public void setLogin(String login) {
	this.login = login;
}
public void setPassword(String password) {
	this.password = password;
}
}
