package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name = "sprache")
public class Sprache implements Serializable {

    private static final long serialVersionUID = -6880605298666105115L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String sprache;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }
}
