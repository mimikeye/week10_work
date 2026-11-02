package org.webservice.songcrud.repository;

import org.webservice.songcrud.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}