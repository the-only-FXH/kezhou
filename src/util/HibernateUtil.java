package util;
/*
 * ×¢²áhibernate
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public final class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ThreadLocal session=new ThreadLocal();
	private HibernateUtil(){}
	static {
		Configuration cfg=new Configuration();
		cfg.configure();
		ServiceRegistry serviceRegistry = 
				new ServiceRegistryBuilder().applySettings(cfg.getProperties())
				                            .buildServiceRegistry();
		sessionFactory=cfg.buildSessionFactory(serviceRegistry);
	}
	public static Session getThreadLocalSession(){
		Session s=(Session)session.get();
		if(s==null){
			s=sessionFactory.openSession();
			session.set(s);
			
		}
		return s;
		
	}
	public static void closeSession(){
		Session s=(Session)session.get();
		if(s!=null){
			s.close();
			session.set(null);
			
		}
	
		
	}

}
