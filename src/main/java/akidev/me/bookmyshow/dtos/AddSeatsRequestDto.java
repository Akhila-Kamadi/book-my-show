package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class AddSeatsRequestDto {
    private Long auditoriumId;
    private Map<SeatType, Integer> seatCount;

    // SeatType -> seatCount
    // VIP - 10
    //Platinum -20
    //Gold - 15
}
