package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name="genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = -5690712600257377583L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
