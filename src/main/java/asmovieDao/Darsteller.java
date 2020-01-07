package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "moviedb", name = "darsteller")
public class Darsteller  implements Serializable {

    private static final long serialVersionUID = 5046230144292961091L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String charakter;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToMany
    private List<Media> medias = new ArrayList<Media>();



    public Darsteller() {
    }
}
