package uz.isystem.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.MovieService.model.Movie;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
}
