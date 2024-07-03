package akidev.me.bookmyshow.repositories;

import akidev.me.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie save(Movie movie);
    Optional<Movie> findById(Long movieId);
}
