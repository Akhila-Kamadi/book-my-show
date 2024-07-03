package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieResponseDto {
    private Movie movie;
}
