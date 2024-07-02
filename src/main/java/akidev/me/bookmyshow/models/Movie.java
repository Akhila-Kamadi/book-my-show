package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Language> languages;

    // M : A
    // 1 : M
    // M : 1
    @ManyToMany
    private List<Actor> actors;
    private double rating;
    private int length;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;
}
