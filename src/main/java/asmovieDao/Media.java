package asmovieDao;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



import java.util.List;

@Entity
@Table(schema = "moviedb", name="media")
public class Media implements Serializable {


    private static final long serialVersionUID = 4871843445258010709L;

    public Media(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String titleSortierung;

    private String titleZusatz;

    private String titleOrginal;

    private int laufzeit;

    private Date premiereDatum;

    private Long imdbID;

    private Long imdbVotes;

    private String imdbWertung;

@OneToMany(
        mappedBy = "genres",
        cascade = CascadeType.ALL)
private List<Genre> genres;






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

    public void setId(Long id) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
