package sn.ucad.master.test;

import java.util.ArrayList;
import java.util.List;

import sn.ucad.master.bo.Produit;
import sn.ucad.master.dao.ProduitDao;
import sn.ucad.master.dao.impl.ProduitDaoImpl;

public class TestMockProduit {
	
	public static void main(String[] args) {
		ProduitDao myDaoProd = ProduitDaoImpl.getInstance();
		Produit monProduit = new Produit("REF03", "Portable t�l�phone", 75000, 45);
		
		myDaoProd.saveProduit(monProduit);
		Produit prod = myDaoProd.getProduit("REF03");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Produit :"+prod.getReferenc()+ "  "+prod.getDesignation()+
				" Prix :"+prod.getPrix()+" QTE :"+prod.getQuantite());
		System.out.println("------------------------------------------------------------------------");
		
		myDaoProd.deleteProduit(prod.getReferenc());
		List<Produit> mesProduits = new ArrayList<Produit>();
		mesProduits = myDaoProd.getProduits();
		for(Produit myProduit:mesProduits){
			System.out.println("Produit :"+myProduit.getReferenc()+ "  "+myProduit.getDesignation()+
				" Prix :"+myProduit.getPrix()+" QTE :"+myProduit.getQuantite());
		}
	}

}
