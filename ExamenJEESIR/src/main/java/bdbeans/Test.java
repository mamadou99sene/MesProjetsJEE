package bdbeans;

public class Test {

	public static void main(String[] args) {
		Produit p=new Produit();
		p.setLibelle("hhjj");
		p.setNumero("dlkcldss");
		p.setPrix(122);
		new ProduitHome().persist(p);
	}

}
