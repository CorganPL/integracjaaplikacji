import models.entities.Album;
import models.entities.Band;
import models.entities.Song;
import models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/administration/")
public class AdministrationController {

    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;
    private final RateRepository rateRepository;

    @Autowired
    public AdministrationController(UserRepository userRepository, SongRepository songRepository, AlbumRepository albumRepository,
                                    BandRepository bandRepository, RateRepository rateRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.bandRepository = bandRepository;
        this.rateRepository = rateRepository;
    }

    @PutMapping("confirmSong/{sId}")
    public Song confirmSong(@PathVariable Long sId) {
        Optional<Song> songTmp = songRepository.findById(sId);
        Song songToConfirm = songTmp.get();

        if(!songToConfirm.isConfirmed()) {
            songToConfirm.setConfirmed(true);
        }

        return songToConfirm;
    }

    @PutMapping("confirmAlbum/{aId}")
    public Album confirmAlbum(@PathVariable Long aId) {
        Optional<Album> albumTmp = albumRepository.findById(aId);
        Album albumToConfirm = albumTmp.get();

        if(!albumToConfirm.isConfirmed()) {
            albumToConfirm.setConfirmed(true);
        }

        return albumToConfirm;
    }

    @PutMapping("confirmBand/{bId}")
    public Band confirmBand(@PathVariable Long bId) {
        Optional<Band> bandTmp = bandRepository.findById(bId);
        Band bandToConfirm = bandTmp.get();

        if(!bandToConfirm.isConfirmed()) {
            bandToConfirm.setConfirmed(true);
        }

        return bandToConfirm;
    }

    @DeleteMapping("removeSong/{sId}")
    public ResponseEntity removeSong(@PathVariable Long sId) {
        songRepository.deleteById(sId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("removeAlbum/{aId}")
    public ResponseEntity removeAlbum(@PathVariable Long aId) {
        albumRepository.deleteById(aId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("removeBand/{bId}")
    public ResponseEntity removeBand(@PathVariable Long bId) {
        bandRepository.deleteById(bId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
