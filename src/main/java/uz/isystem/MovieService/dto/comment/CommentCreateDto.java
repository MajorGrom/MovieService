package uz.isystem.MovieService.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CommentCreateDto {

    @NotBlank
    private String comment;
    @NotNull(message = "Movie ID is not given")
    private UUID movieId;
    @NotNull(message = "User ID is not given")
    private UUID userId;
}
