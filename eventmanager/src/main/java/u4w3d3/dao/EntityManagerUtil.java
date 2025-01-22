package u4w3d3.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    /**
     * Factory per la creazione di {@link EntityManager}.
     * Inizializzata con l'unità di persistenza configurata nel file
     * persistence.xml.
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventManagerPU");

    /**
     * Restituisce un'istanza di {@link EntityManager} per interagire con il
     * database.
     *
     * @return Un nuovo {@link EntityManager}.
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Chiude l'istanza di {@link EntityManagerFactory}.
     * <p>
     * Questo metodo deve essere chiamato alla fine del ciclo di vita
     * dell'applicazione per liberare
     * correttamente le risorse allocate.
     */
    public static void close() {
        emf.close();
    }
}
