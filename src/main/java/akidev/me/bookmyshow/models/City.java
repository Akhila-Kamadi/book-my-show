package akidev.me.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    private String name;
    // C : T
    // 1 : M
    // 1 : 1
    @OneToMany
    private List<Theatre> theatres;
}
