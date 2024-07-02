package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "show_seat_mapping")
public class ShowSeat extends BaseModel{
    // SS : S
    // 1 : 1
    // M : 1
    @ManyToOne
    private Show show;

    // SS : Seat
    // 1 : 1
    // M : 1
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
