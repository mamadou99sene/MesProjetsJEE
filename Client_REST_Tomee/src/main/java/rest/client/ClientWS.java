package rest.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
public class ClientWS {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build(); 
		HttpGet getRequest = new
		HttpGet("http://localhost:8080/TP_WS_REST_TomEE/rs/comptes");
		getRequest.addHeader("accept", "application/json");
		HttpResponse response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : " + 
		response.getStatusLine().getStatusCode());
		}
		BufferedReader br = new BufferedReader(new
		InputStreamReader((response.getEntity().getContent())));
		String output;
		while ((output = br.readLine()) != null) {
		System.out.println(output);
		}


	}

}
