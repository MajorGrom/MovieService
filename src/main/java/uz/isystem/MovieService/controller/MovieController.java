package uz.isystem.MovieService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.MovieService.dto.movie.MovieCreateDto;
import uz.isystem.MovieService.dto.movie.MovieDetailDto;
import uz.isystem.MovieService.model.Movie;
import uz.isystem.MovieService.service.MovieService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        MovieDetailDto response = movieService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid MovieCreateDto movie) {
        Movie response = movieService.create(movie);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody @Valid MovieCreateDto dto) {
        Movie response = movieService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        String response = movieService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Movie> response = movieService.getAll();
        return ResponseEntity.ok(response);
    }
}
