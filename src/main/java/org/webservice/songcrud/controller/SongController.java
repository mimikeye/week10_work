package org.webservice.songcrud.controller;

import org.webservice.songcrud.dto.SongRequest;
import org.webservice.songcrud.dto.SongResponse;
import org.webservice.songcrud.service.SongService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SongResponse> create(
            @Valid @RequestBody SongRequest request) {
        SongResponse created = service.create(request);
        return ResponseEntity
                .created(URI.create("/api/songs/" + created.id()))
                .body(created);
    }

    @GetMapping
    public List<SongResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SongResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SongResponse update(
            @PathVariable Long id,
            @Valid @RequestBody SongRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}