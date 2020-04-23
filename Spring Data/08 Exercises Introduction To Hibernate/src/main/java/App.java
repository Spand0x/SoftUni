import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
//    private static final String EMF_PU = "gringotts";
//    private static final String EMF_PU = "sales";
//    private static final String EMF_PU = "university";
//    private static final String EMF_PU = "hospital";
    private static final String EMF_PU = "payment";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMF_PU);
        EntityManager em = emf.createEntityManager();
        Engine engine = new Engine(em);
        engine.run();
    }
}
