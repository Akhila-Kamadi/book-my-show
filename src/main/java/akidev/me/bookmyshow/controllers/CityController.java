package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.AddCityRequestDto;
import akidev.me.bookmyshow.dtos.AddCityResponseDto;
import akidev.me.bookmyshow.models.City;
import akidev.me.bookmyshow.services.CityService;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    public AddCityResponseDto addCity(AddCityRequestDto request){
        City savedCity = cityService.addCity(request.getName());
        AddCityResponseDto response = new AddCityResponseDto();
        response.setCity(savedCity);
        return response;
    }
}
