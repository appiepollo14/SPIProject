package nl.avasten.song;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    private static final String PERSISTENCE_UNIT_NAME = "Song";
    private EntityManagerFactory factory;

    @Test
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        Query q = em.createQuery("select p from Song p");
        // Persons should be empty

        // do we have entries?
        boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so lets create new entries
//        if (createNewEntries) {
//            assertTrue(q.getResultList().size() == 0);
//            Family family = new Family();
//            family.setDescription("Family for the Knopfs");
//            em.persist(family);
//            for (int i = 0; i < 40; i++) {
//                Person person = new Person();
//                person.setFirstName("Jim_" + i);
//                person.setLastName("Knopf_" + i);
//                em.persist(person);
//                // now persists the family person relationship
//                family.getMembers().add(person);
//                em.persist(person);
//                em.persist(family);
//            }
//        }
//
//        // Commit the transaction, which will cause the entity to
//        // be stored in the database
//        em.getTransaction().commit();

        // It is always good practice to close the EntityManager so that
        // resources are conserved.
        em.close();

    }

}