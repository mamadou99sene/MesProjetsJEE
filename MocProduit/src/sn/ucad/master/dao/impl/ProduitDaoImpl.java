package sn.ucad.master.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sn.ucad.master.bo.Produit;
import sn.ucad.master.dao.ProduitDao;
import sn.ucad.master.support.HasmapProudit;

public class ProduitDaoImpl implements ProduitDao {
	//private HashMap<String, Produit> monMockProduit = new HashMap<String,Produit>();
	static private ProduitDaoImpl mockProd;

	private ProduitDaoImpl() {
		
	}
	public static ProduitDaoImpl getInstance() {
		if(mockProd==null)
			mockProd= new ProduitDaoImpl();
		return mockProd;
	}
	@Override
	public void saveProduit(Produit produit) {
		// TODO Auto-generated method stub
		//monMockProduit.put(produit.getReferenc(), produit);
		HasmapProudit.getSupportStockage().put(produit.getReferenc(), produit);
	}

	@Override
	public List<Produit> getProduits() {
		// TODO Auto-generated method stub
		return new ArrayList<Produit>(HasmapProudit.getSupportStockage().values());
	}

	@Override
	public Produit getProduit(String ref) {
		// TODO Auto-generated method stub
		//return monMockProduit.get(ref);
		return HasmapProudit.getSupportStockage().get(ref);
	}

	@Override
	public void updateProduit(Produit produit) {
		// TODO Auto-generated method stub
		if(HasmapProudit.getSupportStockage().get(produit.getReferenc())!= null)
			HasmapProudit.getSupportStockage().put(produit.getReferenc(), produit);
	}

	@Override
	public void deleteProduit(String ref) {
		// TODO Auto-generated method stub		
		HasmapProudit.getSupportStockage().remove(ref);
	}

}
