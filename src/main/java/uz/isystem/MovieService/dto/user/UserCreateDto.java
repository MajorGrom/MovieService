package uz.isystem.MovieService.dto.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import uz.isystem.MovieService.enums.Gender;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserCreateDto {

    private UUID id;
    @NotNull(message = "Name is null")
    @NotEmpty(message = "Name is empty")
    private String name;
    @NotNull(message = "Surname is null")
    @NotEmpty(message = "Surname is empty")
    private String surname;
    @NotNull(message = "Email is null")
    @NotEmpty(message = "Email is empty")
    private String email;
    @NotNull(message = "Address is null")
    @NotEmpty(message = "Address is empty")
    private String address;
    @NotNull(message = "Password is null")
    @NotEmpty(message = "Password is empty")
    @Length(min = 4, max = 16, message = "Number of characters in password must be between 4 and 16")
    private String password;
    @NotNull(message = "Birthday is null")
    private LocalDate birthDate;
    private String imageURL;
    private Gender gender;

}
