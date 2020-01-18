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
    private int id;


    private String charakter;

    @ManyToOne
    @JoinColumn(name = "person_ID", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "media_ID",referencedColumnName = "id")
    private Media media ;



    public Darsteller() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharakter() {
        return charakter;
    }

    public void setCharakter(String charakter) {
        this.charakter = charakter;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
