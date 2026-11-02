package org.webservice.songcrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record SongRequest(
        @NotBlank @Size(max = 200) String title,
        @NotBlank @Size(max = 100) String artist,
        @Size(max = 100) String album,
        @NotBlank @Size(max = 50) String genre,
        @NotNull @PositiveOrZero Integer releaseYear
) { }