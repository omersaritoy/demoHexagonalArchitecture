package com.cavcav.demohexagonalarchitecture.application.dao;

import com.cavcav.demohexagonalarchitecture.application.dto.CreateMovieDto;
import com.cavcav.demohexagonalarchitecture.domain.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface MovieDAO {

    Optional<Movie> findMovieByTitle(String title);

    List<Movie> findAllMovies();

    void saveMovie(CreateMovieDto movie);

    void updateMovie(Movie newMovie);

    void deleteMovie(Movie movie);

}
