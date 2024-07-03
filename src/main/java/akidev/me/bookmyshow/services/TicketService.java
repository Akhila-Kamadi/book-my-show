package akidev.me.bookmyshow.services;

import akidev.me.bookmyshow.exceptions.ShowSeatNotAvailableException;
import akidev.me.bookmyshow.models.ShowSeat;
import akidev.me.bookmyshow.models.Ticket;
import akidev.me.bookmyshow.models.enums.ShowSeatStatus;
import akidev.me.bookmyshow.models.enums.TicketStatus;
import akidev.me.bookmyshow.repositories.ShowRepository;
import akidev.me.bookmyshow.repositories.ShowSeatRepository;
import akidev.me.bookmyshow.repositories.TicketRepository;
import akidev.me.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;

    private ShowRepository showRepository;
    private UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository,
                         ShowSeatRepository showSeatRepository,
                         ShowRepository showRepository,
                         UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Ticket bookTicket(
            Long showId,
            List<Long> showSeatIds,
            Long userId
    ) throws ShowSeatNotAvailableException {
        //Fetch ShowSeats from given list
        //Check if each of them are available
        //Update the status as locked
        //save and return ticket object
        List<ShowSeat> showSeats = showSeatRepository.findByIdIn(showSeatIds);

        for (ShowSeat showSeat : showSeats){
            if (!ShowSeatStatus.AVAILABLE.equals(showSeat.getShowSeatStatus())){
                throw new ShowSeatNotAvailableException("ShowSeat ID: "+
                        showSeat.getId() + " not available.");
            }
        }

        for (ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setBookedBy(userRepository.findById(userId).get());
        ticket.setShow(showRepository.findById(showId).get());
        ticket.setTimeOfBooking(new Date());
        ticket.setShowSeats(showSeats);

        ticketRepository.save(ticket);
        return null;
    }
}
