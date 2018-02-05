package informatica.senai.sp.br.albumsnroll.logic.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Album {
    //attributes
    private Long id;
    private String name;
    private String genre;
    private Date releaseDate;
    private Boolean willBeDelete;


    //instances
    private static SimpleDateFormat fmtData =
            new SimpleDateFormat("dd/MM/yyyy");
    //  private static DateFormat fmtData = DateFormat.getDateInstance(DateFormat.SHORT);

    //Constructors
    public Album() {
        this.willBeDelete = false;
    }

    public Album(Long id) {
        this.willBeDelete = false;
        this.id = id;
    }

    public Album(String name, String genre, Date releaseDate) {
        this.willBeDelete = false;
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Album(Long id, String name, String genre, Date releaseDate) {
        this.willBeDelete = false;
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

    public String getReleaseDateString() {
        return fmtData.format(releaseDate);
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getWillBeDelete() {
        if (this.willBeDelete != null) {
            return willBeDelete;
        } else {
            return false;
        }
    }

    public Integer getWillBeDeleteInteger() {
        if (this.willBeDelete == null) {
            return 0;
        } else if (this.willBeDelete) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setWillBeDelete(Boolean willBeDelete) {
        this.willBeDelete = willBeDelete;
    }

    public void setWillBeDelete(int willBeDelete) {

        this.willBeDelete = willBeDelete == 1;
    }
}
