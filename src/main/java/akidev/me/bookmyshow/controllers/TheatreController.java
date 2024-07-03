package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.*;
import akidev.me.bookmyshow.exceptions.AuditoriumNotFoundException;
import akidev.me.bookmyshow.exceptions.CityNotFoundException;
import akidev.me.bookmyshow.exceptions.TheatreNotFoundException;
import akidev.me.bookmyshow.models.Theatre;
import akidev.me.bookmyshow.services.TheatreService;
import org.springframework.stereotype.Controller;

@Controller
public class TheatreController {
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public CreateTheatreResponseDto createTheatre(CreateTheatreRequestDto request) throws CityNotFoundException {
        Theatre savedTheatre = theatreService.createTheatre(request.getName(), request.getAddress(), request.getCityId());
        CreateTheatreResponseDto response = new CreateTheatreResponseDto();
        response.setTheatre(savedTheatre);
        return response;
    }

    //we created auditorium inside theatre... using auditorium controller
    //method 2: add audi from theatre controller -> returns theatre object

    public AddAuditoriumToTheatreResponseDto addAuditorium(AddAuditoriumToTheatreRequestDto request) throws TheatreNotFoundException {
        Theatre savedTheatre = theatreService.addAuditorium(request.getTheatreId(),
                request.getAuditoriumName(),
                request.getCapacity());
        AddAuditoriumToTheatreResponseDto response = new AddAuditoriumToTheatreResponseDto();
        response.setTheatre(savedTheatre);
        return response;
    }

    //Add seats to auditorium
    //In which auditorium you want to add, How many seats of what type
    public void addSeats(AddSeatsRequestDto request) throws AuditoriumNotFoundException {
        theatreService.addSeats(request.getAuditoriumId(), request.getSeatCount());
    }
}

