package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.ShowFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    // S : M
    // 1 : 1
    // M : 1
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    // S : A
    // 1 : 1
    // M : 1
    @ManyToOne
    private Auditorium auditorium;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ShowFeature> showFeatures;

    @Enumerated(EnumType.STRING)
    private Language language;

    // S : SS
    // 1 : M
    // 1 : 1
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;

    // S : SST
    // 1 : M
    // 1 : 1
    @OneToMany(mappedBy = "show")
    private List<ShowSeatType> showSeatTypes;
}
