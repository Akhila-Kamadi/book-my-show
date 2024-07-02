package akidev.me.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;
    private String address;
    private List<Auditorium> auditoriums;
    private List<Show> upcomingShows;
}
