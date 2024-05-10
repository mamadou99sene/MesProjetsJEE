 package ws;

import jakarta.xml.ws.Endpoint;

public class Server {

	public static void main(String[] args) {
		String url="http://localhost:8989/Calculateur";
		Endpoint.publish(url, new Calculateur());
		System.out.println(url+"?WSDL");

	}

}
