package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//La classe d'implementation de l'interface
public class IcalculImpl extends UnicastRemoteObject implements Icalcul,Serializable{

	protected IcalculImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculerfacto(int nombre) throws RemoteException {
		// TODO Auto-generated method stub
		int facto=1;
		for(int i=1;i<=nombre;i++)
		{
			facto=facto*i;
		}
		return facto;
	}

}
