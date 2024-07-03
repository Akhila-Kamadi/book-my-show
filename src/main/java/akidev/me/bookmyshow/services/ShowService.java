package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.exceptions.AuditoriumNotFoundException;
import akidev.me.bookmyshow.exceptions.MovieNotFoundException;
import akidev.me.bookmyshow.models.*;
import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.SeatType;
import akidev.me.bookmyshow.models.enums.ShowSeatStatus;
import akidev.me.bookmyshow.repositories.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowService {
    private ShowRepository showRepository;
    private MovieRepository movieRepository;
    private AuditoriumRepository auditoriumRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;

    public ShowService(ShowRepository showRepository,
                       MovieRepository movieRepository,
                       AuditoriumRepository auditoriumRepository,
                       ShowSeatRepository showSeatRepository,
                       ShowSeatTypeRepository showSeatTypeRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public Show addShow(Long movieId, Long auditoriumId,
                        Date startTime, Date endTime,
                        Map<SeatType, Integer> seatPricing,
                        Language language) throws MovieNotFoundException, AuditoriumNotFoundException {
        //check and fetch movie and audi
        //create and save show
        // add showseats to show for all seats in audi
        // add pricing for each seattype in the show

        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (!movieOptional.isPresent()) {
            throw new MovieNotFoundException("No movie with ID: " + movieId);
        }
        Optional<Auditorium> auditoriumOptional = auditoriumRepository.findById(auditoriumId);
        if (!auditoriumOptional.isPresent()) {
            throw new AuditoriumNotFoundException("No auditorium with ID: " + auditoriumId);
        }
        Movie dbMovie = movieOptional.get();
        Auditorium dbAuditorium = auditoriumOptional.get();

        Show show = new Show();
        show.setAuditorium(dbAuditorium);
        show.setMovie(dbMovie);
        show.setStartTime(startTime);
        show.setEndTime(endTime);
        show.setLanguage(language);

        Show savedShow = showRepository.save(show);

        //Create showseats -> as many as there are seats in the auditorium
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for (Seat seat : dbAuditorium.getSeats()) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(savedShow);
            showSeat.setSeat(seat);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);

            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        savedShow.setShowSeats(savedShowSeats);
        savedShow = showRepository.save(savedShow);

        //Add price to each showType
        List<ShowSeatType> savedShowSeatTypes = new ArrayList<>();
        for (Map.Entry<SeatType, Integer> entry : seatPricing.entrySet()) {
            SeatType seatType = entry.getKey();
            int price = entry.getValue();
            ShowSeatType showSeatType = new ShowSeatType();
            showSeatType.setShow(savedShow);
            showSeatType.setSeatType(seatType);
            showSeatType.setPrice(price);

            savedShowSeatTypes.add(showSeatTypeRepository.save(showSeatType));
        }

        savedShow.setShowSeatTypes(savedShowSeatTypes);
        savedShow = showRepository.save(savedShow);

        return savedShow;
    }
}
