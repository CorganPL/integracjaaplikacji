import models.entities.*;
import models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/rate")
@RestController
public class RatingController {
    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;
    private final RateRepository rateRepository;

    @Autowired
    public RatingController(UserRepository userRepository, SongRepository songRepository, AlbumRepository albumRepository,
                            BandRepository bandRepository, RateRepository rateRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.bandRepository = bandRepository;
        this.rateRepository = rateRepository;
    }

    @PostMapping("{uId}/song/{sId}")
    public void rateSong(@PathVariable Long sId, @PathVariable Long uId, double rateValue) {
        Optional<User> userTmp = userRepository.findById(uId);
        Optional<Song> songTmp = songRepository.findById(sId);

        User user = userTmp.get();
        Song song = songTmp.get();
        Rate rate = new Rate(uId, sId, rateValue);
        user.addRateToHistory(rate);
        song.addRate(rate);
    }

    @PostMapping("{uId}/album/{aId}")
    public void rateAlbum(@PathVariable Long aId, @PathVariable Long uId, double rateValue) {
        Optional<User> userTmp = userRepository.findById(uId);
        Optional<Album> albumTmp = albumRepository.findById(aId);

        User user = userTmp.get();
        Album album = albumTmp.get();
        Rate rate = new Rate(uId, aId, rateValue);
        user.addRateToHistory(rate);
        album.addRate(rate);
    }

    @PostMapping("{uId}/band/{bId}")
    public void rateBand(@PathVariable Long sId, @PathVariable Long uId, double rateValue) {
        Optional<User> userTmp = userRepository.findById(uId);
        Optional<Song> songTmp = songRepository.findById(sId);

        User user = userTmp.get();
        Song song = songTmp.get();
        Rate rate = new Rate(uId, sId, rateValue);
        user.addRateToHistory(rate);
        song.addRate(rate);
    }

    @GetMapping("{sId}")
    public List<Rate> getSongRates(@PathVariable Long sId) {
        Optional<Song> songTmp = songRepository.findById(sId);
        Song song = songTmp.get();

        return song.getRates();
    }

    @GetMapping("{aId}")
    public List<Rate> getAlbumRates(@PathVariable Long aId) {
        Optional<Album> albumTmp = albumRepository.findById(aId);
        Album album = albumTmp.get();

        return album.getRates();
    }

    @GetMapping("{bId}")
    public List<Rate> getBandRates(@PathVariable Long bId) {
        Optional<Band> bandTmp = bandRepository.findById(bId);
        Band band = bandTmp.get();

        return band.getRates();
    }


}
