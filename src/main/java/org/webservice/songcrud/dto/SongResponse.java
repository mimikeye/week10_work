package org.webservice.songcrud.dto;

import org.webservice.songcrud.entity.Song;

public record SongResponse(
        Long id, String title, String artist, String album,
        String genre, Integer releaseYear
) {
    public static SongResponse from(Song song) {
        return new SongResponse(
                song.getId(),
                song.getTitle(),
                song.getArtist(),
                song.getAlbum(),
                song.getGenre(),
                song.getReleaseYear()
        );
    }
}