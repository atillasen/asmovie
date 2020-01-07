package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name = "land")
public class Land implements Serializable {


    private static final long serialVersionUID = 400086930221709108L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String land;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
