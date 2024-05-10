package momo.calcul;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calculateur {
	@WebMethod
public int somme(int a, int b)
{
	return a+b;
}
public int diff(int a,int b)
{
	return a-b;
}
}
