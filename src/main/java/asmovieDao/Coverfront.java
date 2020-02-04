package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "moviedb",name = "coverfront")
public class Coverfront implements Serializable {


    private static final long serialVersionUID = -4875256216258844671L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] coverfront; 


    public byte[] getCoverfront() {
        return coverfront;
    }

    public void setCoverfront(byte[] coverfront) {
        this.coverfront = coverfront;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
