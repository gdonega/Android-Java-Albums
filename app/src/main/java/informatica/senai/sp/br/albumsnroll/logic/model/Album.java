package informatica.senai.sp.br.albumsnroll.logic.model;

import java.util.Date;


public class Album {
    //attributes
    private Long id;
    private String name;
    private String genre;
    private Date releaseDate;
    private byte[] cover;

    //Constructors
    public Album() {
    }

    public Album(Long id) {
        this.id = id;
    }

    public Album(String name, String genre, Date releaseDate, byte[] cover) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.cover = cover;
    }

    public Album(Long id, String name, String genre, Date releaseDate, byte[] cover) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.cover = cover;
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

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }
}
