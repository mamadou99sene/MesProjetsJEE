package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Connexion {
	private Connection connection;
	private PreparedStatement prStatement;
	public void se_connecter()
	{
		try {
		Class.forName("org.postgresql.Driver");	
		connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/jee_db","postgres","Senemomo");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Personne authentification(String email, String password)
	{
		se_connecter();
		Personne personne=null;
		try 
		{
			prStatement=connection.prepareStatement("select * from personnes where email=? and password=?");
			prStatement.setString(1, email);
			prStatement.setString(2, password);
			ResultSet result=prStatement.executeQuery();
			while(result.next())
			{
				int id=result.getInt("idPersonne");
				String pass=result.getString("password");
				String prenom=result.getString("prenom");
				String nom=result.getString("nom");
				String mail=result.getString("email");
			    personne=new Personne(id, nom,  pass,  prenom, mail);
			}
			
		} catch (SQLException e) {
		System.out.println("Erreur de recuperation au niveau de la base de donnees "+e.getMessage());	
		}
		return personne;
		
	}

}
