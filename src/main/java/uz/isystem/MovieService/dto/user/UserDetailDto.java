package uz.isystem.MovieService.dto.user;


import lombok.Getter;
import lombok.Setter;
import uz.isystem.MovieService.enums.Gender;
import uz.isystem.MovieService.enums.UserStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserDetailDto {
    private String name;
    private String surname;
    private String email;
    private String address;
    private LocalDate birthDate;
    private Gender gender;
    private UserStatus status;
}
