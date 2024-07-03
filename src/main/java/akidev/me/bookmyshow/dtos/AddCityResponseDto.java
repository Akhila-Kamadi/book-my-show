package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCityResponseDto {
    private City city;
}
