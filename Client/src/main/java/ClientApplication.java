import models.entities.*;

public class ClientApplication {

    public static void main(String[] args) {
        ClientUser clientUser = new ClientUser();
        ClientAdmin clientAdmin = new ClientAdmin();

        clientUser.addBand(new Band(Long.valueOf(100), "Abba", "Sweden", 1972));
        clientAdmin.confirmBand(Long.valueOf(100));

        clientUser.addAlbum(new Album(Long.valueOf(1000), Long.valueOf(100), "Arrival", Genre.POP));
        clientAdmin.confirmAlbum(Long.valueOf(1000));

        clientUser.addSong(new Song(Long.valueOf(10000), "Dancing Queen", 3:51));
        clientAdmin.confirmSong(Long.valueOf(10000));

        clientUser.rateSong(new Rate(Long.valueOf(10000), Long.valueOf(1), 5.0));

    }
}
