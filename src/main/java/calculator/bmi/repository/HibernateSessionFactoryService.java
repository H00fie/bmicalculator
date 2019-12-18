package calculator.bmi.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class HibernateSessionFactoryService {

    private SessionFactory sessionFactory;

    public HibernateSessionFactoryService(){
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession(){
        return this.sessionFactory.openSession();
    }
}
