package momo.contact;
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import DAO.Metiers; 
public class TestHiber {
	public static void main(String [] args)
	{
		try 
		{ 
			//serviceRegistry= new StandardServiceRegistryBuilder().build();
			/*SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();*/
			Contact contact=new Contact();
			contact.setId(1);
			contact.setEmail("mamadou@99");
			contact.setPrenom("Mamadou");
			contact.setNom("SENE");
			Metiers.ajouter(contact);
		  } 
		catch(Exception e)
		 { 
			/*if(tr!=null)
			{
				tr.rollback();
			}
			throw e;*/
			System.out.println("Impossible d'enregistrer la ligne dans la base de donnees "+e.getMessage());
		 }
		finally
		{
			//session.flush();
			//session.close();
		}
		//fact.close();
	}

}