package web;

import java.util.ArrayList;
import java.util.List;

public class BanqueService {
	List<Compte> listcp;

	public BanqueService() {
		List<Compte> cptes = new ArrayList<Compte>();
		cptes.add(new Compte(1, Math.random() * 10000));
		cptes.add(new Compte(2, Math.random() * 10000));
		listcp = cptes;
	}

	public double conversion(double mt) {
		return mt * 655;
	}

	public Compte getCompte(long cpt) {
		int obj = 999;
		for (int i = 0; i < listcp.size(); i++) {
			if (listcp.get(i).getNumero() == cpt)
				obj = i;
		}
		return listcp.get(obj);
	}

	public List<Compte> getComptes() {
		return this.listcp;
	}

	public void addCompte(Compte compte) {
		listcp.add(compte);
		
	}
}
