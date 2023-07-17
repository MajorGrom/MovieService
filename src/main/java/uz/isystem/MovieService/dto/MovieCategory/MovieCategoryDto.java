package uz.isystem.MovieService.dto.MovieCategory;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class MovieCategoryDto {
    private UUID movieID;
    private UUID categoryID;
}
