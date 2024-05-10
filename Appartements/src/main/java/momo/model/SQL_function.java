package momo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQL_function 
{
  private Connection connection;
  private PreparedStatement pr;
  public static String afficher()
  {
	  String requete="SELECT * FROM appartement";
	  return requete;
  }
  public static String show_details()
  {
	  String requete="SELECT * from appartement where idapp=?";
	  return requete;
  }
  public static String insert_App()
  {
	  String requete="INSERT INTO appartement(libelle,nomimmeuble,type,superficie,nbrepieces,prix,description,adresse,quartier,ville)VALUES(?,?,?,?,?,?,?,?,?,?)";
	  return requete;
  }
  
  public static String update()
  {
	  String requete="UPDATE appartement set prix=? where idApp=?";
	  return requete;
  }
  public static String delete()
  {
	  String requete="DELETE FROM appartement where idapp=?";
	  return requete;
  }
  public static String pre_remplissage()
  {
	  String requete="SELECT * from appartement where idapp=?";
	  return requete;
  }
  public static String recherche()
  {
	  String requete="SELECT * from appartement where adresse like ?  OR ville like ? OR quartier like ?";
	  return requete;
  }
  public static String authentification()
  {
	  String requete="SELECT prenom,nom,id_users,login,password from users where login=? AND password=? ";
	  return requete;
  }
  public static String reserver()
  {
	  String requete="insert into reservation(idapp,id_users)Values(?,?)";
	  return requete;
  }
  
}
