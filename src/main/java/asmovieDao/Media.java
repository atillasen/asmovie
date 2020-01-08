package asmovieDao;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(schema = "moviedb", name="media")
public class Media implements Serializable {


    private static final long serialVersionUID = 4871843445258010709L;



    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    private String titleSortierung;

    private String titleZusatz;

    private String titleOrginal;

    private int laufzeit;

    private Date premiereDatum;

    private Long imdbID;

    private Long imdbVotes;

    private String imdbWertung;



    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            schema = "moviedb",
            name = "movieAndGenres",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")}

    )
    private List<Genre> genres = new ArrayList<Genre>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            schema = "moviedb",
            name= "movieandstudio",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "studio_id",referencedColumnName = "id")}
    )
    private List<Studio> studios = new ArrayList<Studio>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="darsteller",
            schema = "moviedb",
            joinColumns = {@JoinColumn(name = "medias_id",referencedColumnName = "id")},
           inverseJoinColumns = {@JoinColumn(name = "darsteller_id", referencedColumnName = "id")}
    )
    private List<Darsteller> darstellerList = new ArrayList<Darsteller>();

    @ManyToOne
    private Sprache sprache;

    @ManyToOne
    private Land land;

    public Media(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Studio> getStudios() {
        return studios;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Date getPremiereDatum() {
        return premiereDatum;
    }

    public void setPremiereDatum(Date premiereDatum) {
        this.premiereDatum = premiereDatum;
    }

    public Long getImdbID() {
        return imdbID;
    }

    public void setImdbID(Long imdbID) {
        this.imdbID = imdbID;
    }

    public Long getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(Long imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbWertung() {
        return imdbWertung;
    }

    public void setImdbWertung(String imdbWertung) {
        this.imdbWertung = imdbWertung;
    }

    public int getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(int laufzeit) {
        this.laufzeit = laufzeit;
    }

    public String getTitleOrginal() {
        return titleOrginal;
    }

    public void setTitleOrginal(String titleOrginal) {
        this.titleOrginal = titleOrginal;
    }

    public String getTitleZusatz() {
        return titleZusatz;
    }

    public void setTitleZusatz(String titleZusatz) {
        this.titleZusatz = titleZusatz;
    }



    public String getTitleSortierung() {
        return titleSortierung;
    }

    public void setTitleSortierung(String titleSortierung) {
        this.titleSortierung = titleSortierung;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Darsteller> getDarstellerList() {
        return darstellerList;
    }

    public void setDarstellerList(List<Darsteller> darstellerList) {
        this.darstellerList = darstellerList;
    }
}
