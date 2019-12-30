package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb", name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 7067419037730056443L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
