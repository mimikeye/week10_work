package org.webservice.songcrud.entity;

import org.webservice.songcrud.dto.SongRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// 클래스를 Entity로 지정해서 데이터 베이스의 테이블과 매핑한다.
@Table(name = "songs")
public class Song {
    //Id는 데이터 베이스 테이블에서 기본 키를 제공한다.
    @Id
    //기본 키 값을 자동 생성
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Entity의 필드를 데이터 베이스의 테이블의 Column과 매핑해 연결된다.
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