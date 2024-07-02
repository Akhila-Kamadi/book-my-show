package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * For every seat-type for a show, what is the price for that seat-type for that show
 */
@Entity
@Getter
@Setter
@Table(name = "show_seat_type_mapping")
public class ShowSeatType extends BaseModel{

    // SST : S
    // 1 : 1
    // M : 1
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private double price;
}
