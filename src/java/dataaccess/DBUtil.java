package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    /**
     * 
     */
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("HavenCyclesPU");

    /**
     * 
     * @return 
     */
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
    /**
     * 
     */
    public static void close() {
        emf.close();
    }
}
