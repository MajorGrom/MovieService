package uz.isystem.MovieService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.isystem.MovieService.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @Column(name = "user_id")
    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;
    @Column(name = "movie_id")
    private UUID movieId;

    private String comment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
