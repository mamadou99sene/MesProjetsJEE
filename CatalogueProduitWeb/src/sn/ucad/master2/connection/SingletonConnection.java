package sn.ucad.master2.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
	private static Connection connection;
	
	private SingletonConnection(){
		
	}
	
	
//	static{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CATALOG_PROD","root","");
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	public static Connection getConnection() {
		if(connection == null){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/produitcatalogue","postgres","Senemomo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		}
		return connection;
	
	}

}