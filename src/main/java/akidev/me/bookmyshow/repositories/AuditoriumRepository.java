package akidev.me.bookmyshow.repositories;

import akidev.me.bookmyshow.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
    Auditorium save(Auditorium auditorium);
    Optional<Auditorium> findById(Long auditoriumId);
}
