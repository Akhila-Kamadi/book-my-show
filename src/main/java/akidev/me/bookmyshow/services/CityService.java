package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.models.City;
import akidev.me.bookmyshow.repositories.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addCity(String name){
        City city = new City();
        city.setName(name);
        return cityRepository.save(city);
    }
}
