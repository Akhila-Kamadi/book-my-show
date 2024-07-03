package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.exceptions.TheatreNotFoundException;
import akidev.me.bookmyshow.models.Auditorium;
import akidev.me.bookmyshow.models.Theatre;
import akidev.me.bookmyshow.repositories.AuditoriumRepository;
import akidev.me.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditoriumService {
    private AuditoriumRepository auditoriumRepository;
    private TheatreRepository theatreRepository;

    public AuditoriumService(AuditoriumRepository auditoriumRepository, TheatreRepository theatreRepository) {
        this.auditoriumRepository = auditoriumRepository;
        this.theatreRepository = theatreRepository;
    }

    public Auditorium createAuditorium(String name, int capacity, Long theatreId) throws TheatreNotFoundException {
        //check if theatre exists
        //Create audi and save
        //fetch theatre and add audi to theatre
        //save theatre
        Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
        if (!theatreOptional.isPresent()){
            throw new TheatreNotFoundException("No theatre with given ID: "+theatreId);
        }

        Auditorium auditorium = new Auditorium();
        auditorium.setName(name);
        auditorium.setCapacity(capacity);
        auditorium.setTheatre(theatreOptional.get());
        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);

        Theatre dbTheatre = theatreOptional.get();
        dbTheatre.getAuditoriums().add(savedAuditorium);

        theatreRepository.save(dbTheatre);

        return savedAuditorium;
    }
}
