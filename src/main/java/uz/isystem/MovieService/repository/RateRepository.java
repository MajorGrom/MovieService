package uz.isystem.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.isystem.MovieService.model.Rate;

import java.util.Optional;
import java.util.UUID;

public interface RateRepository extends JpaRepository<Rate, UUID> {

    @Query(value = "SELECT avg(rate) from rate where movie_id = ?1",nativeQuery = true)
    Float getAvgID(UUID uuid);
}
