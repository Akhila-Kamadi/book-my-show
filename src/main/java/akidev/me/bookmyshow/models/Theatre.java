package akidev.me.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;
    private String address;

    // T : A
    // 1 : M
    // 1 : 1
    @OneToMany(mappedBy = "theatre", fetch = FetchType.EAGER)
    private List<Auditorium> auditoriums = new ArrayList<>();

    // T : S
    // 1 : M
    // 1 : 1
    @OneToMany
    private List<Show> upcomingShows;
}
