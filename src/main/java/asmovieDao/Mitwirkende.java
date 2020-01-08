package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name ="mitwirkende")
public class Mitwirkende implements Serializable {

    private static final long serialVersionUID = 3755387537783825238L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_ID", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "media_ID",referencedColumnName = "id")
    private Media media ;

    @ManyToOne
    @JoinColumn(name="funktion_id", referencedColumnName = "id")
    private Funktion funktion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Funktion getFunktion() {
        return funktion;
    }

    public void setFunktion(Funktion funktion) {
        this.funktion = funktion;
    }
}
