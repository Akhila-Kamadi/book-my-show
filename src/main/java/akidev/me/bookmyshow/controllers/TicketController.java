package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.BookTicketRequestDto;
import akidev.me.bookmyshow.dtos.BookTicketResponseDto;
import akidev.me.bookmyshow.exceptions.ShowSeatNotAvailableException;
import akidev.me.bookmyshow.models.Ticket;
import akidev.me.bookmyshow.services.TicketService;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) throws ShowSeatNotAvailableException {
        Ticket savedTicket = ticketService.bookTicket(request.getShowId(), request.getShowSeatIds(), request.getUserId());
        BookTicketResponseDto response = new BookTicketResponseDto();
        response.setTicket(savedTicket);
        return response;
    }
}
/*
 * To make a booking
 * we need to have everything that is there in ticket ->
 * 1.create city,
 * 2.create user,
 * 3.create a theatre and create an auditorium in the theatre with seats
 * 4.create a movie
 * 5.create a show
 */
