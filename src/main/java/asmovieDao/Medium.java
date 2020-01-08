package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name="medium")
public class Medium implements Serializable {

    private static final long serialVersionUID = -2481809581539820783L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String medium;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
