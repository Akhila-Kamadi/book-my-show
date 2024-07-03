package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class AddShowRequestDto {
    private Long movieId;
    private Long auditoriumId;
    private Date startTime;
    private Date endTime;
    private Language language;
    private Map<SeatType, Integer> seatPricing; //-> pricing for each seatType
    //Showseats are not given by client
    // based on auditorium they are automatically created
    //for every seat that is there, we will create corresponding showseat
}
