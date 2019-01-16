package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private Long albumId;

    private String title;
    private Time duration;
    private Genre genre;
    private double avgRate;
    private List<Rate> rates;
    private List<String> comments;
    private boolean isConfirmed;

    public Song(Long albumId, String title, Time duration) {
        this.albumId = albumId;
        this.title = title;
        this.duration = duration;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAvgRate() {
        double sum = 0;
        for (Rate r: rates) {
            sum += r.getRate();
        }
        this.avgRate = sum/rates.size();
    }

    public double getAvgRate() {
        return avgRate;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public void addRate(Rate r) {
        this.rates.add(r);
    }

    public void removeRate(Rate r) {
        this.rates.remove(r);
    }

    public void addComment(String comment) {
        this.comments.add(comment);
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
