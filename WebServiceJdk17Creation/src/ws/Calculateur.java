package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class Calculateur {
	@WebMethod
	public int add(int a, int b)
	{
		return a+b;
	}

}
