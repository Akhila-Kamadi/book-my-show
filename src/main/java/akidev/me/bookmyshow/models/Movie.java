package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.Language;
import akidev.me.bookmyshow.models.enums.MovieFeature;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private List<Language> languages;
    private List<Actor> actors;
    private double rating;
    private int length;
    private List<MovieFeature> movieFeatures;
}
