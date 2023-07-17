package uz.isystem.MovieService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.MovieService.dto.category.CategoryDto;
import uz.isystem.MovieService.model.Category;
import uz.isystem.MovieService.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        CategoryDto response = categoryService.get(id);
        return ResponseEntity.ok(response);
    }



    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CategoryDto dto) {
        Category response = categoryService.create(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody @Valid CategoryDto dto) {
        Category response = categoryService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        String response = categoryService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Category> response = categoryService.getAll();
        return ResponseEntity.ok(response);
    }

}
