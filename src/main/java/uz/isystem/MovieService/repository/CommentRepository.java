package uz.isystem.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.isystem.MovieService.model.Comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findByMovieId(UUID id);
    List<Comment> findByUserId(UUID id);
}
