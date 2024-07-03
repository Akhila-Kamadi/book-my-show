package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.AddShowRequestDto;
import akidev.me.bookmyshow.dtos.AddShowResponseDto;
import akidev.me.bookmyshow.exceptions.AuditoriumNotFoundException;
import akidev.me.bookmyshow.exceptions.MovieNotFoundException;
import akidev.me.bookmyshow.models.Show;
import akidev.me.bookmyshow.services.ShowService;
import org.springframework.stereotype.Controller;

@Controller
public class ShowController {
    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    public AddShowResponseDto addShow(AddShowRequestDto request)
            throws MovieNotFoundException, AuditoriumNotFoundException {
        Show savedShow = showService.addShow(request.getMovieId(),
                request.getAuditoriumId(),
                request.getStartTime(),
                request.getEndTime(),
                request.getSeatPricing(),
                request.getLanguage());

        AddShowResponseDto response = new AddShowResponseDto();
        response.setShow(savedShow);
        return response;
    }
}
