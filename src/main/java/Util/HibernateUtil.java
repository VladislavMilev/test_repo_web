package Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static StandardServiceRegistry standartServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if(sessionFactory == null){
                standartServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

                MetadataSources metadataSources = new MetadataSources(standartServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        }catch (Exception e){
            e.printStackTrace();
            if(standartServiceRegistry != null){
                StandardServiceRegistryBuilder.destroy(standartServiceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
