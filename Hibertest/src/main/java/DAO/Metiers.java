package DAO;

import org.hibernate.Session;

import momo.contact.Contact;
import momo.contact.HibernateUtil;

public class Metiers{
	public static void ajouter(Contact contatc)
	{
		Session session=HibernateUtil.configureSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(contatc);
		session.getTransaction().commit();
	}
}
