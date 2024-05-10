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
 * @see bdbeans.Personnes
 * @author Hibernate Tools
 */
public class PersonnesHome {

	private static final Log log = LogFactory.getLog(Personnes.class);
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

	public  Personnes connexion(String password,String email) {
		Session session=null;
		if (null == password ) {
			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
		}		
		try { session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personnes.class);
			//crit.add(Restrictions.eq("password", password.trim()));
			crit.add(Restrictions.eq("email", email));
			Object o=crit.uniqueResult();
			if(o!=null) 
			{
			Personnes user = (Personnes)o;//sous-classement
			if(user.getPassword().equals(password))
			{
				session.close();
				return user;
			}
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			// Critical errors : database unreachable, etc.
			return null;
		}
		/*finally{
			session.close();
		}*/
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Personnes> getAllPersonnes(){
		 session = sessionFactory.openSession();

		try{Criteria crit = session.createCriteria(Personnes.class);
			@SuppressWarnings("rawtypes")
			List l=crit.list();
			session.close();
		    List<Personnes> res=(ArrayList<Personnes>)l;

			return  res;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Personnes  findPersonnesByID(int id){
		Session session=null;
		try {
			 session = sessionFactory.openSession();
			// create a new criteria
			Criteria crit = session.createCriteria(Personnes.class);
			crit.add(Restrictions.eq("idpersonne", id));

			Personnes user = (Personnes)crit.uniqueResult();
			if (user==null){session.close();return null;}
			else {session.close();return user;}
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}

	}
	
	public void persist(Personnes transientInstance) {
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
	public void update(Personnes transientInstance) {
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
	public void delete(Personnes transientInstance) {
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

	
	public List<Personnes> getAllPersonnesUniques(){
		//List<Classe> xx=new ArrayList<Classe>();
	    Session session = sessionFactory.openSession ( );
	    String SQL_QUERY ="from Personnes";
	    Query query = session.createQuery (SQL_QUERY);
	    @SuppressWarnings("rawtypes")
		List l=query.list();
	    @SuppressWarnings("unchecked")
		List<Personnes> xx=(List<Personnes>)l;
	  /*  for (Iterator<Classe> it = query.iterate ( );it.hasNext();)
	    {
	    	Classe c =it.next ( );
	                 xx.add(c);
	     } 
	   // session.close();*/
	    return xx;	
	}	

	
}
