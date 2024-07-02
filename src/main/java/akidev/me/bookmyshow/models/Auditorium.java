package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.AuditoriumFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    private String name;
    private List<Seat> seats;
    private int capacity;
    private List<AuditoriumFeature> auditoriumFeatures;
    private Theatre theatre;
}
