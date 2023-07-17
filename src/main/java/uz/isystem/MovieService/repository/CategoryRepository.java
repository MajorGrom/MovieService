package uz.isystem.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.MovieService.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
