package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.Auditorium;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAuditoriumResponseDto {
    private Auditorium auditorium;
}
