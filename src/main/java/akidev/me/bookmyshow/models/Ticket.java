package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.TicketStatus;
import jakarta.persistence.*;
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

    // T : SS
    // 1 : M
    // M : 1
    //If one person booked that particular seat for that particular show,
    // but he cancelled it --> it is available for booking
    // hence it can be booked again => 1 SS -> can be booked multiple times
    //If no cancellation -> 1:M
    @ManyToMany
    private List<ShowSeat> showSeats;

    // T : U
    // 1 : 1
    // M : 1
    @ManyToOne
    private User bookedBy;

    // T : S
    // 1 : 1
    // M : 1
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private Date timeOfBooking;
}
