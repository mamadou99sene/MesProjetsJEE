package momo.calcul;

import javax.xml.ws.Endpoint;

public class Serveur {

	public static void main(String[] args) {
		String url="http://localhost/Calculateur";
		Endpoint.publish(url, new Calculateur());
		System.out.println(url+"?WSDL");

	}

}
