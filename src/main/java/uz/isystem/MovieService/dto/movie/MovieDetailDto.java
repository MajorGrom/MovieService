package uz.isystem.MovieService.dto.movie;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter

public class MovieDetailDto {

    private String name;
    private String description;
    private LocalDate publishedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
