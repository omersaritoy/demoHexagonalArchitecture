package com.cavcav.demohexagonalarchitecture.application.dto;

import java.time.LocalDate;

public record CreateMovieDto(
        String title,
        String description,
        LocalDate releaseDate,
        String directorName
) {
}
