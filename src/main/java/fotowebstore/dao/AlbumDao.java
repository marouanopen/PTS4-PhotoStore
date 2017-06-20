package fotowebstore.dao;

import fotowebstore.entities.Album;
import fotowebstore.entities.User;

import java.util.List;

public interface AlbumDao {
    Album create(Album album);

    Album update(Album album);

    boolean delete(Album album);

    Album find(int id);

    Album findByVoucherCode(String voucherCode);

    void linkUserAndAlbum(User user, Album album);

    List<Album> findAll();

    void save();
}
