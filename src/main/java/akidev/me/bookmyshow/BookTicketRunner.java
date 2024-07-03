package akidev.me.bookmyshow;

import akidev.me.bookmyshow.controllers.TicketController;
import akidev.me.bookmyshow.dtos.BookTicketRequestDto;
import akidev.me.bookmyshow.exceptions.ShowSeatNotAvailableException;

import java.util.List;

public class BookTicketRunner implements Runnable{
    private TicketController ticketController;
    private BookTicketRequestDto bookTicketRequest;

    public BookTicketRunner(TicketController ticketController, BookTicketRequestDto bookTicketRequest) {
        this.ticketController = ticketController;
        this.bookTicketRequest = bookTicketRequest;
    }

    @Override
    public void run() {
        try{
            this.ticketController.bookTicket(bookTicketRequest);
        } catch (ShowSeatNotAvailableException e) {
            System.out.println("EXCEPTION OCCURRED.........."+e.getMessage());
        }
    }
}
