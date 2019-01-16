import models.entities.Album;
import models.entities.Band;
import models.entities.Song;
import models.entities.User;
import models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/add")
@RestController
public class AddingController {
    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;
    private final RateRepository rateRepository;

    @Autowired
    public AddingController(UserRepository userRepository, SongRepository songRepository, AlbumRepository albumRepository,
                            BandRepository bandRepository, RateRepository rateRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.bandRepository = bandRepository;
        this.rateRepository = rateRepository;
    }

    @PostMapping("{uId}/band")
    public Band addBand(@PathVariable Long uId, @RequestBody Band bandToAdd) {
        Optional<User> userTmp = userRepository.findById(uId);
        User user = userTmp.get();
        user.addBandToHistory(bandToAdd);
        return bandToAdd;
    }

    @PostMapping("{uId}/album/{bId}")
    public Album addAlbum(@PathVariable Long uId, @RequestBody Album albumToAdd, @RequestBody Long bId ) {
        Optional<User> userTmp = userRepository.findById(uId);
        Optional<Band> bandTmp = bandRepository.findById(bId);
        User user = userTmp.get();
        Band band = bandTmp.get();

        user.addAlbumToHistory(albumToAdd);
        band.addAlbumToDiscography(albumToAdd);
        return albumToAdd;
    }

    @PostMapping("{uId}/song/{aId}")
    public Song addSong(@PathVariable Long uId, @RequestBody Song songToAdd, @RequestBody Long aId) {
        Optional<User> userTmp = userRepository.findById(uId);
        Optional<Album> albumTmp = albumRepository.findById(aId);
        User user = userTmp.get();
        Album album = albumTmp.get();

        user.addSongToHistory(songToAdd);
        album.addSongToAlbum(songToAdd);
        return songToAdd;
    }


}
