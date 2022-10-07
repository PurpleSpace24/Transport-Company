package configuration;

import entity.Company;
import entity.Driver;
import entity.Vehicle;
import entity.Client;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Company.class)
                    .addAnnotatedClass(Driver.class)
                    .addAnnotatedClass(Vehicle.class).addAnnotatedClass(Client.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

}
