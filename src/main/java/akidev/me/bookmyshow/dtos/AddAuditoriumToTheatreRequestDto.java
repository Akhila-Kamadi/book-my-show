package akidev.me.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuditoriumToTheatreRequestDto {
    private Long theatreId;
    private String auditoriumName;
    private int capacity;
}
