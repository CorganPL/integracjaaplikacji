package models.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

public class Band {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;
    private String origin;
    private int year;
    private double avgRate;
    private List<Rate> rates;
    private List<String> comments;
    private boolean isConfirmed;

    private List<Album> discography;

    public Band(Long id, String name, String origin, int year) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.year = year;
    }

    public void addAlbumToDiscography(Album album) {
        discography.add(album);
    }

    public void addRate(Rate r) {
        this.rates.add(r);
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public List<Rate> getRates() {
        return this.rates;
    }

    public List<String> getComments() {
        return this.comments;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
