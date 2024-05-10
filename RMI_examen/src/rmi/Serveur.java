package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
//La classe serveur
public class Serveur {
	protected Serveur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Icalcul client=null;
        try
        {
        	LocateRegistry.createRegistry(1099);
        	System.out.println("Demarrage du serveur...");
        	client=new IcalculImpl();
        }
        catch(RemoteException e)
        {
        	System.out.println("Erreur d'ouverture du port "+e.getMessage());
        }
        try
        {
        	try
        	{
        		Naming.rebind("rmi://localhost:1099/client", client);	
        	}	
        	catch(RemoteException e)
        	{
        		System.out.println("Erreur de connexion au serveur "+e.getMessage());
        	}
        }
        catch(MalformedURLException ex)
        {
        	System.out.println("Impossible d'associer cet URL a 'objet distant"+ex.getMessage());
        }
        
	}


}
