package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Icalcul extends Remote{
	public int calculerfacto(int nombre) throws RemoteException;

}
