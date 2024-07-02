package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.ShowFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private Auditorium auditorium;
    private List<ShowFeature> showFeatures;
    private Language language;
    private List<ShowSeat> showSeats;
    private List<ShowSeatType> showSeatTypes;
}
