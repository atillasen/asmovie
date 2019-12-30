package asmovieController;


import asmovieDao.Media;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class MediaController implements Serializable {

    private static final long serialVersionUID = -5113706513285455852L;

    @Inject
    private Media media;

    public Media getMedia(){
        return media;
    }

    public void setMedia(Media media){
        this.media = media;
    }


}
