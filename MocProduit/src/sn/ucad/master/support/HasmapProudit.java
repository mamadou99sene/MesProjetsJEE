package sn.ucad.master.support;

import java.util.HashMap;

import sn.ucad.master.bo.Produit;

public class HasmapProudit {
	
	private static HashMap<String, Produit> monMockProduit = new HashMap<String,Produit>();
	
	private HasmapProudit() {
		
	}
	
	public static HashMap<String, Produit>  getSupportStockage() {
		if(monMockProduit==null)
			 monMockProduit = new HashMap<String,Produit>();
		return monMockProduit;
	}

}
