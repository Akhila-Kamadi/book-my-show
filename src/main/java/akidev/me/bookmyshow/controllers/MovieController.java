package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.CreateMovieRequestDto;
import akidev.me.bookmyshow.dtos.CreateMovieResponseDto;
import akidev.me.bookmyshow.models.Movie;
import akidev.me.bookmyshow.services.MovieService;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public CreateMovieResponseDto createMovie(CreateMovieRequestDto request){
        Movie savedMovie = movieService.createMovie(request.getName());
        CreateMovieResponseDto response = new CreateMovieResponseDto();
        response.setMovie(savedMovie);
        return response;
    }
}
