package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.Theatre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTheatreResponseDto {
    private Theatre theatre;
}