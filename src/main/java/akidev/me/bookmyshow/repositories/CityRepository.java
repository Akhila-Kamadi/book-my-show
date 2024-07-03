package akidev.me.bookmyshow.repositories;

import akidev.me.bookmyshow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City save(City city);
    Optional<City> findById(Long cityId);
}
