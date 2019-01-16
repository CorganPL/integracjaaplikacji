package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private Long artistId;

    String title;
    private Genre genre;
    private double avgRate;
    private List<Rate> rates;
    private List<String> comments;
    private boolean isConfirmed;

    private List<Song> songs;

    public Album(Long id, Long artistId, String title, Genre genre) {
        this.id = id;
        this.artistId = artistId;
        this.title = title;
        this.genre = genre;
    }

    public void addSongToAlbum(Song song) {
        this.songs.add(song);
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
