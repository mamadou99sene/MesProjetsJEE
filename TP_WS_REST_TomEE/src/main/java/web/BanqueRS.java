package web;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("comptes")
@Produces("application/xml")
public class BanqueRS {
	BanqueService bs;

	public BanqueRS() {
		bs = new BanqueService();
	}

	@GET
	public List<Compte> getComptes() {
		return bs.getComptes();
	}
	@GET
	@Path( "{numero}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Compte getCompte(@PathParam("numero")long cpt){
	 return bs.getCompte(cpt);
	}
	@GET
	@Path("EurotoFcfa/{montant}")
	//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces("application/json")
	public double conversion(@PathParam("montant")double mt){
	return bs.conversion(mt);
	}
	
	
	@GET
	@Produces("application/json")
	public List<Compte> getComptesjson(){
	return bs.getComptes();
	}
	
	
	@POST
	@Consumes("application/xml")
	public Response createCompte(InputStream is) {
	Compte compte = readCompte(is);
	bs.addCompte(compte);
	return Response.created(URI.create("/comptes/"+compte.getNumero())).build();
	} 
	

	@PUT
	@Path("{numero}")
	@Consumes("application/xml")
	public Response updateCompte(@PathParam("numero") int numero, InputStream is) 
	{
	Compte cpt= bs.getCompte(numero);
	Compte ucpt = readCompte(is);
	cpt.setSolde(ucpt.getSolde());
	cpt.setDatecreation(ucpt.getDatecreation());
	return Response.accepted().build();
	}

	private Compte readCompte(InputStream is) 
	{
		Compte cpt = new Compte(); 
		try {
		DocumentBuilder builder =
		DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(is);
		Element root = doc.getDocumentElement(); 
		NodeList nodes = root.getChildNodes(); 
		for (int i = 0; i < nodes.getLength(); i++) {
		Element element = (Element) nodes.item(i);
		if (element.getTagName().equals("numero")) {
		cpt.setNumero( Long.parseLong(element.getTextContent()) );
		}
		else if (element.getTagName().equals("solde")) {
		cpt.setSolde( Double.parseDouble(element.getTextContent()) );
		}
		else if (element.getTagName().equals("datecreation")) { 
		cpt.setDatecreation(Long.parseLong(element.getTextContent()));
		}
		}
		}catch(Exception exp){
		throw new WebApplicationException(exp,
		Response.Status.BAD_REQUEST);
		}

		return cpt;
	}
}

