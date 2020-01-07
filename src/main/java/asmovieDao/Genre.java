package asmovieDao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "moviedb", name="genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = -5690712600257377583L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String genre;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "movieandgenres",
            joinColumns = {@JoinColumn(name = "genre_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "media_ID", referencedColumnName = "id")}
            )
    private Set<Genre> usedGenres = new HashSet<>();

    public Set<Genre> getUsedGenres() {
        return usedGenres;
    }

    public void setUsedGenres(Set<Genre> usedGenres) {
        this.usedGenres = usedGenres;
    }

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }
}
