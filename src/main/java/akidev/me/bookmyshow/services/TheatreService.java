package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.exceptions.AuditoriumNotFoundException;
import akidev.me.bookmyshow.exceptions.CityNotFoundException;
import akidev.me.bookmyshow.exceptions.TheatreNotFoundException;
import akidev.me.bookmyshow.models.Auditorium;
import akidev.me.bookmyshow.models.City;
import akidev.me.bookmyshow.models.Seat;
import akidev.me.bookmyshow.models.Theatre;
import akidev.me.bookmyshow.models.enums.SeatType;
import akidev.me.bookmyshow.repositories.AuditoriumRepository;
import akidev.me.bookmyshow.repositories.CityRepository;
import akidev.me.bookmyshow.repositories.SeatRepository;
import akidev.me.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;
    private CityRepository cityRepository;
    private AuditoriumRepository auditoriumRepository;
    private SeatRepository seatRepository;

    public TheatreService(TheatreRepository theatreRepository, CityRepository cityRepository,
                          AuditoriumRepository auditoriumRepository,
                          SeatRepository seatRepository) {
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.seatRepository = seatRepository;
    }

    public Theatre createTheatre(String name, String address, Long cityId) throws CityNotFoundException {
        //check if city exists
        //Create a theatre obj and save to db
        //Fetch city by id
        //add theatre to the city
        // save the city
        Optional<City> cityOptional = cityRepository.findById(cityId);
        if (!cityOptional.isPresent()) {
            throw new CityNotFoundException("No city with given ID: " + cityId);
        }
        Theatre theatre = new Theatre();
        theatre.setAddress(address);
        theatre.setName(name);
        Theatre savedTheatre = theatreRepository.save(theatre);

        City dbCity = cityOptional.get();
        dbCity.getTheatres().add(savedTheatre);
        this.cityRepository.save(dbCity);

        return savedTheatre;
    }

    public Theatre addAuditorium(
            Long theatreId,
            String name,
            int capacity
    ) throws TheatreNotFoundException {
        //Fetch theatre by id
        // create and save auditorium
        // add auditorium to theatre
        Optional<Theatre> theatreOptional = theatreRepository.findById(theatreId);
        if (!theatreOptional.isPresent()) {
            throw new TheatreNotFoundException("Theatre not fount with ID: " + theatreId);
        }

        Theatre theatre = theatreOptional.get();

        Auditorium auditorium = new Auditorium();
        auditorium.setCapacity(capacity);
        auditorium.setName(name);
        auditorium.setTheatre(theatre);
        Auditorium savedAuditorium = auditoriumRepository.save(auditorium);

        theatre.getAuditoriums().add(savedAuditorium);
        Theatre savedTheatre = theatreRepository.save(theatre);

        return savedTheatre;
    }

    public void addSeats(Long auditoriumId,
                         Map<SeatType, Integer> seatCount) throws AuditoriumNotFoundException {
        //Fetch auditorium
        //from map get the seat count for a seatType
        //Iterate over map-> for each seatType -> add seatnumber and seatType
        //add to list
        //save all seats
        // add list<seats> in auditorium
        Optional<Auditorium> auditoriumOptional = auditoriumRepository.findById(auditoriumId);
        if (!auditoriumOptional.isPresent()) {
            throw new AuditoriumNotFoundException("No Auditorium with ID: " + auditoriumId);
        }

        Auditorium auditorium = auditoriumOptional.get();

        List<Seat> seats = new ArrayList<>();

        for (Map.Entry<SeatType, Integer> seatTypeEntry : seatCount.entrySet()) {
            SeatType seatType = seatTypeEntry.getKey();
            int count = seatTypeEntry.getValue();
            for (int i = 0; i < count; i++) {
                Seat seat = new Seat();
                seat.setSeatType(seatType);
                seat.setSeatNumber(seatType.toString() + (i + 1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = seatRepository.saveAll(seats);

        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);

    }
}
