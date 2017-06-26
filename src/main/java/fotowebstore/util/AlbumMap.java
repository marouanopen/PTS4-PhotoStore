package fotowebstore.util;

import fotowebstore.entities.Album;

import java.util.Set;

public class AlbumMap {

    private Set<Album> ownedAlbums;
    private Set<Album> voucherAlbums;

    public AlbumMap(Set<Album> ownedAlbums, Set<Album> voucherAlbums) {
        this.ownedAlbums = ownedAlbums;
        this.voucherAlbums = voucherAlbums;
    }

    public Set<Album> getOwnedAlbums() {
        return ownedAlbums;
    }

    public void setOwnedAlbums(Set<Album> ownedAlbums) {
        this.ownedAlbums = ownedAlbums;
    }

    public Set<Album> getVoucherAlbums() {
        return voucherAlbums;
    }

    public void setVoucherAlbums(Set<Album> voucherAlbums) {
        this.voucherAlbums = voucherAlbums;
    }
}
