package fotowebstore.dao;

import fotowebstore.entities.Photo;

import java.util.List;

public interface PhotoDao {
    Photo create(Photo photo);

    Photo update(Photo photo);

    boolean delete(Photo photo);

    List<Photo> findAll();
}
