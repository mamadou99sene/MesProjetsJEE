package momo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Connect {
	private Connection connection;
	private PreparedStatement prstatement;
	private ResultSet resultset;
	public void se_connecter()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Echec lors de chargement du driver "+e.getMessage());
		}
		try
		{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banque","root","");
		} 
		catch (SQLException e) {
			
			System.out.println("Impossible de se connecter a la base de donnees "+e.getMessage());
		}
	}
	public ArrayList<Personnel> verification(Personnel per,String numero)
	{
		se_connecter();
		String prenom=null;
		double solde=0.0;
		ArrayList<Personnel> personne=new ArrayList<Personnel>();
	//	Personnel per=new Personnel();
		try
		{
			prstatement=connection.prepareStatement("SELECT * FROM compte where numero=?");
			prstatement.setString(1, numero);
			resultset=prstatement.executeQuery();
			while(resultset.next())
			{
				 prenom=resultset.getString("prenom");
				 solde=resultset.getDouble("solde");
				 per.setPrenom(prenom);
				 per.setSolde(solde);
				 personne.add(per);
			}
			
		} catch (SQLException e) {
			
			System.out.println("Erreur de lecture dans la Base de donees "+e.getMessage());
		}
		return personne;
	}

}
