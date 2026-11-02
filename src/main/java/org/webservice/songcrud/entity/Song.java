package org.webservice.songcrud.entity;

import org.webservice.songcrud.dto.SongRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 100)
    private String artist;

    @Column(length = 100)
    private String album;

    @Column(nullable = false, length = 50)
    private String genre;

    @Column(nullable = false)
    private Integer releaseYear;

    protected Song() { }

    public Song(SongRequest request) {
        this.title = request.title();
        this.artist = request.artist();
        this.album = request.album();
        this.genre = request.genre();
        this.releaseYear = request.releaseYear();
    }

    public void update(SongRequest request) {
        this.title = request.title();
        this.artist = request.artist();
        this.album = request.album();
        this.genre = request.genre();
        this.releaseYear = request.releaseYear();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public String getGenre() { return genre; }
    public Integer getReleaseYear() { return releaseYear; }
}