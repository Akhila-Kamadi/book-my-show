package akidev.me.bookmyshow.repositories;

import akidev.me.bookmyshow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    Theatre save(Theatre theatre);
    Optional<Theatre> findById(Long theatreId);
}
