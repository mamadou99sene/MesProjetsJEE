package sn.ucad.master.dao;

import java.util.List;

import sn.ucad.master.bo.Produit;

public interface ProduitDao {
	
	public void saveProduit(Produit produit);
	public List<Produit> getProduits();
	public Produit getProduit(String ref);
	public void updateProduit(Produit produit);
	public void deleteProduit(String ref);


}
