package uz.isystem.MovieService.dto.movie;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MovieCreateDto {

    @NotEmpty(message = "Name is empty")
    @NotNull(message = "Name is null")
    private String name;
    @NotEmpty(message = "Description is empty")
    @NotNull(message = "Description is null")
    private String description;
    @NotNull(message = "Date is null")
    private LocalDate publishedAt;

}
