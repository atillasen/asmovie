package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name = "customer")
public class Customer  implements Serializable {
    private static final long serialVersionUID = 8768841081649238701L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer;



}
