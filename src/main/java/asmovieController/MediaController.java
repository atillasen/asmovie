package asmovieController;

import asmovieDao.Media;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.io.Serializable;

@Named
@RequestScoped
public class MediaController  implements Serializable {


    private static final long serialVersionUID = -4761067820469405479L;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @Inject
    private Media media;

    public Media getMedia(){
        return media;
    }

    public void setMedia(Media media){
        this.media = media;
    }

    public String persist(){
        try {
            ut.begin();
            em.persist(media);
            ut.commit();
        }catch (Exception e){
            e.printStackTrace();
            return "reject";
        }
            return "confirm";
    }
}
