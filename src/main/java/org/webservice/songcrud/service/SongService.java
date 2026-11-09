package org.webservice.songcrud.service;

import org.webservice.songcrud.dto.SongRequest;
import org.webservice.songcrud.dto.SongResponse;
import org.webservice.songcrud.entity.Song;
import org.webservice.songcrud.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SongService {
    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public SongResponse create(SongRequest request) {
        //새 Entity를 save()로 전달, 데이터 베이스에 새 데이터를 등록한다.
        Song saved = repository.save(new Song(request));
        return SongResponse.from(saved);
    }

    public List<SongResponse> findAll() {
        return repository.findAll().stream()
                .map(SongResponse::from)
                .toList();
    }

    public SongResponse findById(Long id) {
        return SongResponse.from(findEntity(id));
    }

    //메서드를 하나의 트랜잭션으로 관리한다. Entity 필드가 변하면  JPA가 자동으로 반영한다. -> Dirty Checking
    @Transactional
    public SongResponse update(Long id, SongRequest request) {
        Song song = findEntity(id);
        song.update(request);
        return SongResponse.from(song);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Song not found: " + id);
        }
        repository.deleteById(id);
    }

    private Song findEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Song not found: " + id));
    }

    public List<SongResponse> searchByTitle(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword)
                .stream()
                .map(SongResponse::from)
                .toList();
    }

    public List<SongResponse> searchByGenreAndYear(
            String genre, Integer startYear, Integer endYear) {
        return repository.findByGenreAndReleaseYearBetween(
                        genre, startYear, endYear)
                .stream()
                .map(SongResponse::from)
                .toList();
    }

    public List<SongResponse> findAllOrderByReleaseYearDesc() {
        return repository.findAllByOrderByReleaseYearDesc()
                .stream()
                .map(SongResponse::from)
                .toList();
    }

}