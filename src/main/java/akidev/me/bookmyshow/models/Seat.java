package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.SeatType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;
    private SeatType seatType;
}
