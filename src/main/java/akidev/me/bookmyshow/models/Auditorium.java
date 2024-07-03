package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    private String name;
    // A : S
    // 1 : m
    // 1 : 1
    //-> 1:m
    @OneToMany(fetch = FetchType.EAGER)
    private List<Seat> seats = new ArrayList<>();
    private int capacity;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;

    // A : T
    // 1 : 1
    // M : 1
    //-> m:1
    @ManyToOne
    private Theatre theatre;
}
