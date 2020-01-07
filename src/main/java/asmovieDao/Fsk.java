package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb" , name = "fsk")
public class Fsk implements Serializable {

    private static final long serialVersionUID = -3463499702795509446L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fsk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFsk() {
        return fsk;
    }

    public void setFsk(String fsk) {
        this.fsk = fsk;
    }
}
