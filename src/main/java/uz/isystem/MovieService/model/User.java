package uz.isystem.MovieService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.isystem.MovieService.enums.Gender;
import uz.isystem.MovieService.enums.UserStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "user_test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String password;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
