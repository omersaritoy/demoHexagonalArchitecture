package com.cavcav.demohexagonalarchitecture.adapters.out.postgresJDBC;


import com.cavcav.demohexagonalarchitecture.adapters.out.postgresJDBC.entities.MovieEntity;
import com.cavcav.demohexagonalarchitecture.adapters.out.postgresJDBC.repositories.MovieRepository;
import com.cavcav.demohexagonalarchitecture.application.dao.MovieDAO;
import com.cavcav.demohexagonalarchitecture.application.dto.CreateMovieDto;
import com.cavcav.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDAO {
    private final MovieRepository moviesRepository;
    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return moviesRepository.findMovieByTitle(title);

    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) moviesRepository.findAll())
                .stream()
                .map(movieEntity -> new Movie(
                        movieEntity.id(),
                        movieEntity.title(),
                        movieEntity.description(),
                        movieEntity.releaseDate(),
                        movieEntity.directorName()
                )).toList();

    }

    @Override
    public void saveMovie(CreateMovieDto movie) {
        moviesRepository.save(new MovieEntity(
                null,
                movie.title(),
                movie.description(),
                movie.releaseDate(),
                movie.directorName(),
                null
        ));
    }

    @Override
    public void updateMovie(Movie newMovie) {
        moviesRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {

    }
}