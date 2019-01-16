import models.entities.Album;
import models.entities.Band;
import models.entities.Song;
import models.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/comment")
@RestController
public class CommentingController {
    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;
    private final RateRepository rateRepository;

    @Autowired
    public CommentingController(UserRepository userRepository, SongRepository songRepository, AlbumRepository albumRepository,
                            BandRepository bandRepository, RateRepository rateRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.bandRepository = bandRepository;
        this.rateRepository = rateRepository;
    }

    @PostMapping("{uId}/song/{bId}")
    public void commentBand(@PathVariable Long bId, @PathVariable Long uId, String comment) {
        Optional<Band> bandTmp = bandRepository.findById(bId);

        Band band = bandTmp.get();
        band.addComment(comment);
    }

    @PostMapping("{uId}/album/{aId}")
    public void commentAlbum(@PathVariable Long aId, @PathVariable Long uId, String comment) {
        Optional<Album> albumTmp = albumRepository.findById(aId);

        Album album = albumTmp.get();
        album.addComment(comment);
    }

    @PostMapping("{uId}/comment/{sId}")
    public void commentSong(@PathVariable Long sId, @PathVariable Long uId, String comment) {
        Optional<Song> songTmp = songRepository.findById(sId);

        Song song = songTmp.get();
        song.addComment(comment);
    }

    @GetMapping("{sId}")
    public List<String> getSongComments(@PathVariable Long sId) {
        Optional<Song> songTmp = songRepository.findById(sId);
        Song song = songTmp.get();

        return song.getComments();
    }

    @GetMapping("{aId}")
    public List<String> getAlbumComments(@PathVariable Long aId) {
        Optional<Album> albumTmp = albumRepository.findById(aId);
        Album album = albumTmp.get();

        return album.getComments();
    }

    @GetMapping("{bId}")
    public List<String> getBandComments(@PathVariable Long bId) {
        Optional<Band> bandTmp = bandRepository.findById(bId);
        Band band = bandTmp.get();

        return band.getComments();
    }


}
