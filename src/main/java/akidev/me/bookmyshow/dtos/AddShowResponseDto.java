package akidev.me.bookmyshow.dtos;

import akidev.me.bookmyshow.models.Show;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddShowResponseDto {
    private Show show;
}
