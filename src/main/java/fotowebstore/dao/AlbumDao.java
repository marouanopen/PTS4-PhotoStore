package fotowebstore.dao;

import fotowebstore.entities.Album;

import java.util.List;

public interface AlbumDao {
    Album create(Album album);

    Album update(Album album);

    boolean delete(Album album);

    List<Album> findAll();
}
