package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.TicketStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
//    private String ticketReferenceId;
    private double totalAmount;
    private List<ShowSeat> showSeats;
    private User bookedBy;
    private Show show;
    private TicketStatus ticketStatus;
    private Date timeOfBooking;
}
