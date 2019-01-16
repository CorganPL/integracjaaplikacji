package models.entities;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String userName;
    private short songsRates;
    private short songsAdded;
    private double avgUserRate;
    private Genre favouriteGenre;

    private List<Rate> ratesHistory;
    private List<Song> addedSongs;
    private List<Band> addedBands;
    private List<Album> addedAlbums;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

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

    public short getSongsRates() {
        return songsRates;
    }

    public void setSongsRates(short songsRates) {
        this.songsRates = songsRates;
    }

    public short getSongsAdded() {
        return songsAdded;
    }

    public void setSongsAdded(short songsAdded) {
        this.songsAdded = songsAdded;
    }

    public double getAvgUserRate() {
        return avgUserRate;
    }

    public void setAvgUserRate(double avgUserRate) {
        this.avgUserRate = avgUserRate;
    }

    public Genre getFavouriteGenre() {
        return favouriteGenre;
    }

    public void setFavouriteGenre(Genre favouriteGenre) {
        this.favouriteGenre = favouriteGenre;
    }

    public void addRateToHistory(Rate r) {
        this.ratesHistory.add(r);
    }

    public List<Song> getAddedSongs() {
        return addedSongs;
    }

    public void setAddedSongs(List<Song> addedSongs) {
        this.addedSongs = addedSongs;
    }

    public void addSongToHistory(Song song) {
        this.addedSongs.add(song);
    }

    public void addAlbumToHistory(Album album) {
        this.addedAlbums.add(album);
    }

    public void addBandToHistory(Band band) {
        this.addedBands.add(band);
    }
}
