package uz.isystem.MovieService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.MovieService.dto.MovieCategory.MovieCategoryDto;
import uz.isystem.MovieService.model.MovieCategory;
import uz.isystem.MovieService.service.MovieCategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movieCategory")
public class MovieCategoryController {
    @Autowired
    MovieCategoryService movieCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        MovieCategoryDto response = movieCategoryService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid MovieCategoryDto dto) {
        MovieCategory response = movieCategoryService.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody @Valid MovieCategoryDto dto) {
        MovieCategory response = movieCategoryService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        String response = movieCategoryService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<MovieCategory> response = movieCategoryService.getAll();
        return ResponseEntity.ok(response);
    }
}
