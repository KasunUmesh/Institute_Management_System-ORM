package util;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FactoryConfigration {
    private static FactoryConfigration factoryConfigration;

    private final SessionFactory sessionFactory;


    public FactoryConfigration(){
        Configuration configuration = new Configuration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Student.class);
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public static FactoryConfigration getInstance(){
        return factoryConfigration = factoryConfigration == null?new FactoryConfigration():factoryConfigration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
