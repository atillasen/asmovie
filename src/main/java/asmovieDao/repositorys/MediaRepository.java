package asmovieDao.repositorys;

import asmovieDao.Media;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class MediaRepository   {

    private EntityManager entityManager;

    public MediaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Media> save(Media media){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(media);
            entityManager.getTransaction().commit();
            return Optional.of(media);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Optional<Media> findById(Long id){
        Media media=entityManager.find(Media.class,id);
        return media !=null ? Optional.of(media):Optional.empty();

    }

    public List findAll(){
        return entityManager.createQuery("from Media").getResultList();
    }

    public void deleteById(Long id){
        Media media = entityManager.find(Media.class,id);
        if(media != null){

            try {
                entityManager.getTransaction().begin();
                entityManager.remove(media);
                entityManager.getTransaction().commit();

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

}
