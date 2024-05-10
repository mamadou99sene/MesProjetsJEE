package bd.session.factory.configure;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.*;

public class HibernateUtil {

	private static  SessionFactory sessionFactory=configureSessionFactory();


	public  static SessionFactory configureSessionFactory ( ) throws     HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
       
       ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings
        (configuration.getProperties()).buildServiceRegistry();        
         sessionFactory = configuration.buildSessionFactory(serviceRegistry);
return sessionFactory;
}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void main(String a[]){
		configureSessionFactory();
	}
}
