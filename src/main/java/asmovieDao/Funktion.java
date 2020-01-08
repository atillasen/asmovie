package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name = "funktion")
public class Funktion  implements Serializable {

    private static final long serialVersionUID = -8163171350626681013L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String funktion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunktion() {
        return funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }
}
