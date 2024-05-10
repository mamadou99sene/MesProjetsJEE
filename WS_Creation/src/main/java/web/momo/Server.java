package web.momo;

import jakarta.xml.ws.Endpoint;

public class Server {
	public static void main(String [] args)
	{
		String url="http://localhost:8989/Calculator";
		Endpoint.publish(url, new Calculator());
		System.out.println(url+"?WSDL");
	}

}
