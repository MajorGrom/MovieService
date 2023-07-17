package uz.isystem.MovieService.dto.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    @NotEmpty(message = "Category name is empty")
    @NotNull(message = "Category name is null")
    private String name;
}
