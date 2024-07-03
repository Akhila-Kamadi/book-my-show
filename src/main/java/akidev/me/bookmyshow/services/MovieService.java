package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.models.Movie;
import akidev.me.bookmyshow.repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(String name){
        Movie movie = new Movie();
        movie.setName(name);
        return movieRepository.save(movie);
    }
}
