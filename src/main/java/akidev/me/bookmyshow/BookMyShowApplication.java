package akidev.me.bookmyshow;

import akidev.me.bookmyshow.controllers.*;
import akidev.me.bookmyshow.dtos.*;
import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.SeatType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    private UserController userController;
    private CityController cityController;
    private TheatreController theatreController;
    private AuditoriumController auditoriumController;
    private MovieController movieController;
    private ShowController showController;
    private TicketController ticketController;


    public BookMyShowApplication(UserController userController,
                                 CityController cityController,
                                 TheatreController theatreController,
                                 AuditoriumController auditoriumController,
                                 MovieController movieController,
                                 ShowController showController,
                                 TicketController ticketController) {
        this.userController = userController;
        this.cityController = cityController;
        this.theatreController = theatreController;
        this.auditoriumController = auditoriumController;
        this.movieController = movieController;
        this.showController = showController;
        this.ticketController = ticketController;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        CreateUserRequestDto request = new CreateUserRequestDto();
//        request.setEmail("akhila@gmail.com");
//
//        CreateUserResponseDto response = this.userController.createUser(request);
//
//        AddCityRequestDto cityRequest = new AddCityRequestDto();
//        cityRequest.setName("Hyderabad");
//
//        AddCityResponseDto cityResponse = this.cityController.addCity(cityRequest);

//        CreateTheatreRequestDto theatreRequest = new CreateTheatreRequestDto();
//        theatreRequest.setAddress("KPHB Road, Hyderabad");
//        theatreRequest.setName("PVR");
//        theatreRequest.setCityId(1L);
//
//        CreateTheatreResponseDto savedTheatre = this.theatreController.createTheatre(theatreRequest);

//        CreateAuditoriumRequestDto auditoriumRequest = new CreateAuditoriumRequestDto();
//        auditoriumRequest.setCapacity(150);
//        auditoriumRequest.setName("Audi-1");
//        auditoriumRequest.setTheatreId(2L);
//
//        CreateAuditoriumResponseDto auditoriumResponse = this.auditoriumController.createAuditorium(auditoriumRequest);

//        CreateMovieRequestDto movieRequest = new CreateMovieRequestDto();
//        movieRequest.setName("Wake Up Sid");
//        CreateMovieResponseDto movieResponse = this.movieController.createMovie(movieRequest);

//        AddAuditoriumToTheatreRequestDto auditoriumToTheatreRequest = new AddAuditoriumToTheatreRequestDto();
//        auditoriumToTheatreRequest.setAuditoriumName("Audi 1");
//        auditoriumToTheatreRequest.setCapacity(125);
//        auditoriumToTheatreRequest.setTheatreId(3L);
//
//        AddAuditoriumToTheatreResponseDto auditoriumToTheatreResponse = this.theatreController.addAuditorium(
//                auditoriumToTheatreRequest
//        );

//        Map<SeatType, Integer> seatsForAudi = new HashMap<>();
//        seatsForAudi.put(SeatType.VIP, 20);
//        seatsForAudi.put(SeatType.GOLD, 100);
//
//         AddSeatsRequestDto seatsRequest = new AddSeatsRequestDto();
//         seatsRequest.setSeatCount(seatsForAudi);
//         seatsRequest.setAuditoriumId(1L);
//
//         this.theatreController.addSeats(seatsRequest);

//        AddShowRequestDto showRequest = new AddShowRequestDto();
//        showRequest.setAuditoriumId(1L);
//        showRequest.setMovieId(1L);
//        showRequest.setLanguage(Language.ENGLISH);
//        showRequest.setStartTime(new Date());
//        showRequest.setEndTime(new Date());
//
//        Map<SeatType, Integer> seatPricing = new HashMap<>();
//        seatPricing.put(SeatType.VIP, 400);
//        seatPricing.put(SeatType.GOLD, 250);
//
//        showRequest.setSeatPricing(seatPricing);
//
//        AddShowResponseDto response = this.showController.addShow(showRequest);

        BookTicketRequestDto ticketRequest1 = new BookTicketRequestDto();
        ticketRequest1.setUserId(1L);
        ticketRequest1.setShowSeatIds(List.of(44L,45L,46L));
        ticketRequest1.setShowId(1L);

        BookTicketRunner bookTicketRunner1 = new BookTicketRunner(this.ticketController, ticketRequest1);

        BookTicketRequestDto ticketRequest2 = new BookTicketRequestDto();
        ticketRequest2.setUserId(1L);
        ticketRequest2.setShowSeatIds(List.of(46L,47L,48L));
        ticketRequest2.setShowId(1L);

        BookTicketRunner bookTicketRunner2 = new BookTicketRunner(this.ticketController, ticketRequest2);

        Thread t1 = new Thread(bookTicketRunner1);
        Thread t2 = new Thread(bookTicketRunner2);

        t1.start();
        t2.start();

        //        this.ticketController.bookTicket(ticketRequest1);
    }
}
