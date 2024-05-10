package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;
//La classe client
public class Client {
	public static void main(String [] args) throws MalformedURLException, NotBoundException
	{
		try
		{
		LocateRegistry.getRegistry(1099);
 		Icalcul client=(Icalcul)Naming.lookup("rmi://localhost:1099/client");
 		System.out.println("Donner le nombre a envoyer au serveur");
 		Scanner rep=new Scanner(System.in);
 		int nombre=rep.nextInt();
 		int factoriel=client.calculerfacto(nombre);
 		System.out.println("Le factoriel de "+nombre+" est "+factoriel);
		}
		catch(RemoteException e)
		{
			System.out.println("URL introuvable!!! "+e.getMessage());
		}
	}

}
