package uz.isystem.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.MovieService.model.MovieCategory;

import java.util.UUID;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory, UUID> {
}
