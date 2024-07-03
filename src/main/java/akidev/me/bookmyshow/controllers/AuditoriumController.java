package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.CreateAuditoriumRequestDto;
import akidev.me.bookmyshow.dtos.CreateAuditoriumResponseDto;
import akidev.me.bookmyshow.exceptions.TheatreNotFoundException;
import akidev.me.bookmyshow.models.Auditorium;
import akidev.me.bookmyshow.services.AuditoriumService;
import org.springframework.stereotype.Controller;

@Controller
public class AuditoriumController {
    private AuditoriumService auditoriumService;

    public AuditoriumController(AuditoriumService auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    public CreateAuditoriumResponseDto createAuditorium(CreateAuditoriumRequestDto request) throws TheatreNotFoundException {
        Auditorium savedAuditorium =
                auditoriumService.createAuditorium(request.getName(), request.getCapacity(), request.getTheatreId());
        CreateAuditoriumResponseDto response = new CreateAuditoriumResponseDto();
        response.setAuditorium(savedAuditorium);
        return response;
    }
}
