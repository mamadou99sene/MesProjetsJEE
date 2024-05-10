package bdbeans;
// Generated 27 janv. 2024, 23:06:48 by Hibernate Tools 5.6.7.Final

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import hibernate.sessionfactory.open.SessionFactoryProvider;

/**
 * Home object for domain model class Personnes.
 * @see bdbeans.Produit
 * @author Hibernate Tools
 */
public class ProduitHome {

	private static final Log log = LogFactory.getLog(Produit.class);
Session session;
	private static final SessionFactory sessionFactory= hibernate.sessionfactory.open.SessionFactoryProvider.getSessionFactory();
    
	protected SessionFactory getSessionFactory() {
	try {
		return sessionFactory;
	} catch (Exception e) {
		log.error("Could not locate SessionFactory in JNDI", e);
		throw new IllegalStateException("Could not locate SessionFactory in JNDI");
	}
}

	@SuppressWarnings("unchecked")
	public List<Produit> getAllProduits(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Produit.class);
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Produit> res=(ArrayList<Produit>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Produit  findProduitByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Produit.class);
			crit.add(Restrictions.eq("idProduit", id));

			Produit p = (Produit)crit.uniqueResult();
			if (p==null){session.close();return null;}
			else {session.close();return p;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	
	public void persist(Produit transientInstance) {
		log.debug("persisting Personnes instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		//new RealEncryption(.docry(transientInstance));
		ss.save(transientInstance);
		tx.commit();
		ss.close();
		log.debug("persist successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("persist failed", re);
		throw re;
	}
	}
	public void update(Produit transientInstance) {
		log.debug("update Personnes instance");
		Session ss=null;
		try {ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(transientInstance);
		tx.commit();
		ss.close();
		log.debug("update successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("update failed", re);
		throw re;
	}
	}
	public void delete(Produit transientInstance) {
		log.debug("deleting Personnes instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);
		tx.commit();
		ss.close();
		log.debug("delete successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("delete failed", re);
		throw re;
	}
	}

	
	public List<Produit> getAllPersonnesUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Produit";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Produit> xx=(List<Produit>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}	

	
}
