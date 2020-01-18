import asmovieDao.Darsteller;
import asmovieDao.Media;
import asmovieDao.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception{
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("asmovie-jpa");
        EntityManager em = emf.createEntityManager();

        Person person = new Person();
        Media media = new Media();
        Darsteller darsteller = new Darsteller();



        person.setFirstName("Robert");
        person.setLastName("de Niro");
        media.setTitle("Der Pate");

        darsteller.setMedia(media);
        darsteller.setCharakter("Pate");
        darsteller.setPerson(person);
       List<Darsteller> darstellers = new ArrayList<>();

        darstellers.add(darsteller);
        media.setDarstellerList((List<Darsteller>) darstellers);







        try {
            em.getTransaction().begin();
            em.persist(person);
            em.persist(darsteller);
            em.persist(media);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }





    }


}
