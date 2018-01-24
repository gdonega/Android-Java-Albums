package informatica.senai.sp.br.albumsnroll.logic.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Album {
    //attributes
    private Long id;
    private String name;
    private String genre;
    private Date releaseDate;


    //instances
    private static SimpleDateFormat fmtData =
            new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");

    //Constructors
    public Album() {
    }

    public Album(Long id) {
        this.id = id;
    }

    public Album(String name, String genre, Date releaseDate) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Album(Long id, String name, String genre, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Long getReleaseDateLong() {
        return releaseDate.getTime();
    }

    public String getReleaseDateString(){return fmtData.format(releaseDate);}

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

}
