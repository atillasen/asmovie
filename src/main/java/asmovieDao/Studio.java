package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "moviedb", name = "studio" )
public class Studio implements Serializable {


    private static final long serialVersionUID = 4304853039773196479L;

    public Studio() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String studioName;

    @ManyToMany(mappedBy = "studios")
    private List<Media> mediaList = new ArrayList<Media>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }
}
