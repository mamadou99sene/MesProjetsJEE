package web;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Compte {
	private long numero;
	private double solde;
	private Date datecreation;
	
	public long getNumero() {
		return numero;
	}
	public double getSolde() {
		return solde;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	public Compte()
	{
		numero = 0;
		solde = 0;
		datecreation = new Date();
	}
	public Compte(long n, double s, Date d) {
		numero = n;
		solde = s;
		datecreation = d;
	}

	public Compte(long n, double s) {
		numero = n;
		solde = s;
		datecreation = new Date();
	}
	public void setDatecreation(long parseLong) {
		datecreation=new Date(parseLong);
		
	}


}
