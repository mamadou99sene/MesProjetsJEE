package web.create;

import jakarta.xml.ws.Endpoint;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
@WebService
public class Calculateur {
	 @WebMethod
	    public int add(int a, int b)
	    {
	        return a+b;
	    }
	 public static  void main(String args[])
	    {
	        try {
	            String url="http://localhost:8989/Calculateur";
	            Endpoint.publish(url, new Calculateur());
	            System.out.println(url+"?WSDL");
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
}
