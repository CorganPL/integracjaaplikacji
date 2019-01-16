import models.entities.Album;
import models.entities.Band;
import models.entities.Rate;
import models.entities.Song;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.POST;

public class ClientUser {

    public static final String ADDING_URL = "http://localhost:8080/add";
    public static final String RATING_URL = "http://localhost:8080/rate";
    public static final String COMMENTING_URL = "http://localhost:8080/comment";

    private RestTemplate restTemplate = new RestTemplate();


    public void addBand(Band band) {
        HttpEntity<Band> request = new HttpEntity<>(band);
        ResponseEntity<Band> response = restTemplate
                .exchange(ADDING_URL+"/band", POST, request, Band.class);

        Band responseBody = response.getBody();
    }

    public void addAlbum(Album album) {
        HttpEntity<Album> request = new HttpEntity<>(album);
        ResponseEntity<Album> response = restTemplate
                .exchange(ADDING_URL, POST, request, Album.class);

        Album responseBody = response.getBody();
    }

    public void addSong(Song song) {
        HttpEntity<Song> request = new HttpEntity<>(song);
        ResponseEntity<Song> response = restTemplate
                .exchange(ADDING_URL, POST, request, Song.class);

        Song responseBody = response.getBody();
    }

    public void rateSong(Rate rate) {
        HttpEntity<Rate> request = new HttpEntity<>(rate);
        ResponseEntity<Rate> response = restTemplate
                .exchange(RATING_URL, POST, request, Rate.class);

        Rate responseBody = response.getBody();
    }

    public void commentSong(String comment) {
        HttpEntity<String> request = new HttpEntity<>(comment);
        ResponseEntity<String> response = restTemplate
                .exchange(COMMENTING_URL, POST, request, String.class);

        String responseBody = response.getBody();
    }


}
