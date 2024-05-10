package modeles;
// Generated 8 févr. 2021 12:06:31 by Hibernate Tools 4.0.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bd.SessionFactoryProvider;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Personne.
 * @see bdbeans.Personne
 * @author Hibernate Tools
 */
public class PersonneHome {

	private static final Log log = LogFactory.getLog(PersonneHome.class);
    Session session;
	private static final SessionFactory sessionFactory= SessionFactoryProvider.getSessionFactory();
    
	protected SessionFactory getSessionFactory() {
	try {
		return sessionFactory;
	} catch (Exception e) {
		log.error("Could not locate SessionFactory in JNDI", e);
		throw new IllegalStateException("Could not locate SessionFactory in JNDI");
	}
}
	public void persist(Personne p) {
		log.debug("persisting Personne instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(p);
		tx.commit();
		ss.close();
		log.debug("persist successful");
	} catch (RuntimeException re) {
		log.error("persist failed", re);
		throw re;
	}
	}
	public void update(Personne transientInstance) {
		log.debug("update Personne instance");
		try {Session ss=sessionFactory.openSession();
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
	public void delete(Personne transientInstance) {
		log.debug("deleting Personne instance");
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);//Le SQL est ici
		tx.commit();
		ss.close();
		log.debug("delete successful");
		//ss.close();
	} catch (RuntimeException re) {
		log.error("delete failed", re);
		throw re;
	}
	}
	@SuppressWarnings("unchecked")
	public  String[] getAllPersonne() {
		Session session=null;
		String[] tab=new String[2];
		try {
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.setProjection(Projections.property("nom"));
			crit.setProjection(Projections.property("prenom"));
			List<Object> rows = crit.list();
			for (Object r : rows) {
		        Object []row = (Object[]) r;
		        tab[0]= (String) row[0];
		        tab[1] = (String) row[1];
		      
			}
			//if (user==null){session.close();return null;}
			//else {session.close();return (java.util.ArrayList<String>)user;}
		return tab;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return null;
		}
	}
	public  Personne verifierLoginMotPasse(String login, String motpasse) {
		Session session=null;		
		try { session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.eq("motpasse", motpasse.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Personne user = (Personne)o;
			session.close();
			return user;
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			return null;
		}
	}
	public  Personne verifierLogin(String login) {
		Session session=null;		
		try { session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Personne user = (Personne)o;
			session.close();
			return user;
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			return null;
		}
	}
}
