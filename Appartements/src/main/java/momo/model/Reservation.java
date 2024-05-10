package momo.model;

public class Reservation 
{
   private int id;
   private User user;
   private Appartement appartement;
   public String getHeure() {
	return heure;
}
public void setHeure(String heure) {
	this.heure = heure;
}
private String heure;
public int getId() {
	return id;
}
public User getUser() {
	return user;
}
public Appartement getAppartement() {
	return appartement;
}
public void setId(int id) {
	this.id = id;
}
public void setUser(User user) {
	this.user = user;
}
public void setAppartement(Appartement appartement) {
	this.appartement = appartement;
}
}
