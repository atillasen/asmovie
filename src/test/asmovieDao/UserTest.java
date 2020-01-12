package asmovieDao;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class UserTest {

    @Inject
    private User user;

    @Test
    void createUser() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("asmovie-jpa");
        EntityManager em = emf.createEntityManager();

        user = new User();
        user.setId(1L);
        user.setUserName("atilla");
        user.setPassword("123");

        em.getTransaction().begin();
        em.persist("user");
        em.getTransaction().commit();

        em.close();
        emf.close();



    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getUserName() {
    }

    @Test
    void setUserName() {
    }
}
