package org.webservice.songcrud.service;

import org.webservice.songcrud.dto.SongRequest;
import org.webservice.songcrud.dto.SongResponse;
import org.webservice.songcrud.entity.Song;
import org.webservice.songcrud.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SongService {
    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public SongResponse create(SongRequest request) {
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

    public SongResponse update(Long id, SongRequest request) {
        Song song = findEntity(id);
        song.update(request);
        return SongResponse.from(repository.save(song));
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
}