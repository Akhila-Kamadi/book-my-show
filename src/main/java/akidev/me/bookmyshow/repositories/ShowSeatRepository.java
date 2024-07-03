package akidev.me.bookmyshow.repositories;

import akidev.me.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "javax.persistence.lock.timeout", value = "0")
    })
    List<ShowSeat> findByIdIn(List<Long> showSeatIds);
    /*
    select * from show_seat
    where show_seat_id in ()
    for update
     */
    ShowSeat save(ShowSeat showSeat);
}
