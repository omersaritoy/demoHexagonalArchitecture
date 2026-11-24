package com.cavcav.demohexagonalarchitecture.application.usecases;

import com.cavcav.demohexagonalarchitecture.application.dao.MovieDAO;
import com.cavcav.demohexagonalarchitecture.application.dto.CreateMovieDto;
import com.cavcav.demohexagonalarchitecture.domain.Movie;
import com.cavcav.demohexagonalarchitecture.infrastructure.exceptions.MovieAlreadyExistsException;
import com.cavcav.demohexagonalarchitecture.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieUseCase {

    private final MovieDAO movieDAO;


    public String saveMovie(CreateMovieDto dto) {
        //Check if movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(dto.title()).isPresent();
        if (isPresent) {
            throw new MovieAlreadyExistsException("Movie with title " + dto.title() + " already exists");
        }
        movieDAO.saveMovie(dto);

        return "Movie with title " + dto.title() + " has been saved successfully";
    }

    public List<Movie> getAllMovies(){
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) throws MovieNotFoundException{
        //check if movie is already in DB
        var isPresent = movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent){
            throw new MovieNotFoundException("This movie does not exist");
        }
        movieDAO.updateMovie(movie);
        return "Movie Successfully updated";
    }

    public Movie getMovieByTitle(String movieTitle ){
        return movieDAO.findMovieByTitle(movieTitle).orElseThrow(
                ()-> new MovieNotFoundException("This movie does not exist")
        );
    }


}
