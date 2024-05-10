package employe;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Out;


public class ConnectionInit 
{
	private Connection con;
	private Statement stmt;
  public void initialiseConnection()
   {
	 con=null;
	 stmt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
	    catch(Exception e)
		{
	    	System.out.println("Erreur de chargement du driver "+e.getMessage());
		}
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jeemploye","demba","Senemomo2019");
		}
		catch(SQLException e)
		{
			System.out.println("Erreur de connection a la base de donnees "+e.getMessage());
		}				
   }
  public ArrayList<Utilisateurs> afficher()
  {
	  ArrayList <Utilisateurs> users=new ArrayList<Utilisateurs>();
	  initialiseConnection();
	  ResultSet res=null;
	 try
	 {
		 stmt=con.createStatement();
		 	res=stmt.executeQuery("SELECT * FROM employes");
		 	while(res.next())
		 	{
		 		String prenom=res.getString("prenom");
				String nom = res.getString ("nom") ; 
				String sexe = res.getString ("sexe") ; 
				String adresse = res.getString ("adresse") ; 
				String pays = res.getString ("pays") ; 
				Utilisateurs uti=new Utilisateurs();
				uti.setPrenom(prenom);
				uti.setNom(nom);
				uti.setSexe(sexe);
				uti.setAdresse(adresse);
				uti.setPays(pays);
				users.add(uti);
		 	}
	 }
	 catch(SQLException e)
	 {
		 System.out.println(e.getMessage());
	 }
	 finally
	 {
		 try
		 {
			 res.close();
			 stmt.close();
		 }
		 catch(SQLException e)
		 {
			 System.out.println("Erreur de fermeture "+e.getMessage());
		 }
		 
	 }
	 
	 return users;	  
  }
  public void ajouter(Utilisateurs user)
  {
	  initialiseConnection();
	  PreparedStatement pr=null;
	  try
	  {
		  pr=con.prepareStatement("INSERT INTO employes(prenom,nom,sexe,adresse,pays)values(?,?,?,?,?)");
		  pr.setString(1, user.getPrenom());
		  pr.setString(2, user.getNom());
		  pr.setString(3, user.getSexe());
		  pr.setString(4, user.getAdresse());
		  pr.setString(5, user.getPays());
		  if(user.getPrenom()!="" && user.getNom()!="" && user.getSexe()!=""&& user.getAdresse()!="")
		  {
			  pr.executeUpdate();
		  }
		  
		  
	  }
	  catch(SQLException e)
	  {
		 System.out.println("Erreur de de la preparation "+e.getMessage());
	  }
	  finally
	  {
		  try
		  {
			  pr.close();
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e.getMessage());
		  }
	  }
	 
  }
  public void modifier(Utilisateurs u)
  {
	  initialiseConnection();
	  PreparedStatement pr=null;  
	try
	{
		String sql="UPDATE employes set prenom=?,nom=?,sexe=? where matle=1";
		pr=con.prepareStatement(sql);
		pr.setString(1, u.getPrenom());
		pr.setString(2, u.getNom());
		pr.setString(3, u.getSexe());
		if(u.getPrenom()!=""&& u.getNom()!="" && u.getSexe()!="" && u.getAdresse()!="")
		{
			pr.executeUpdate();
		}
		
	}
	catch(SQLException e)
	{
		System.out.println("Erreur! impossible de modidfier la table "+e.getMessage());
	}
	  
	  
  }
}
