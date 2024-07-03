package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
}
