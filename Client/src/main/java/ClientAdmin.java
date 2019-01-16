import models.entities.Album;
import models.entities.Band;
import models.entities.Song;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.PUT;

public class ClientAdmin {

    public static final String ADMIN_URL = "http://localhost:8080/administration";

    private RestTemplate restTemplate = new RestTemplate();

    public void confirmBand(Long bId) {
        HttpEntity<Band> request = new HttpEntity<>(band);
        ResponseEntity<Song> response = restTemplate.exchange(ADMIN_URL+"/confirmBand", PUT, request, Song.class);
    }

    public void confirmAlbum(Long aId) {
        HttpEntity<Album> request = new HttpEntity<>(album);
        ResponseEntity<Song> response = restTemplate.exchange(ADMIN_URL+"/confirmAlbum", PUT, request, Song.class);
    }

    public void confirmSong(Long sId) {
        HttpEntity<Song> request = new HttpEntity<>(song);
        ResponseEntity<Song> response = restTemplate.exchange(ADMIN_URL+"/confirmSong", PUT, request, Song.class);
    }

    public void deleteSong(Long sId) {
        String deleteUrl = ADMIN_URL + "/removeSong/" + sId;
        restTemplate.delete(deleteUrl);
    }

    public void deleteAlbum(Long aId) {
        String deleteUrl = ADMIN_URL + "/removeAlbum/" + aId;
        restTemplate.delete(deleteUrl);
    }

    public void deleteBand(Long bId) {
        String deleteUrl = ADMIN_URL + "/removeBand/" + bId;
        restTemplate.delete(deleteUrl);
    }

}

