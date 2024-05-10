package momo.authentification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Connexion {
	private Connection connection;
	private PreparedStatement pr;
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
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/examen","demba","Senemomo2019");
		} 
		catch (SQLException e) {
			
			System.out.println("Impossible de se connecter a la base de donnees "+e.getMessage());
		}
	}
	public String [] authentification(String login,String password)
	{
		se_connecter();
		
		String[] informations=new String[2];
		try 
		{
			String requete="SELECT * FROM users where login=? and passwd=?";
			pr=connection.prepareStatement(requete);
			pr.setString(1, login);
			pr.setString(2, password);
			ResultSet res=pr.executeQuery();
			while(res.next())
			{
				String my_login=res.getString("login");
				String my_password=res.getString("passwd");
				String prenom=res.getString("prenom");
				String nom=res.getString("nom");
				/*informations.add(my_login);
				informations.add(my_password);
				informations.add(prenom);
				informations.add(nom);*/
				informations[0]=my_login;
				informations[1]=my_password;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return informations;
	}
	public static void main(String[] args)
	{
		Connexion connexion=new Connexion();
		/*ArrayList list=connexion.authentification("momo","Senemo");
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}*/
		String tab[]=connexion.authentification("momo", "Senemo");
		for(int i=0;i<tab.length;i++)
		{
			System.out.println(tab[i]);
		}
	}

}
