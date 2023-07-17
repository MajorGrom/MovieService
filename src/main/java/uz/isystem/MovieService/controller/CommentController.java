package uz.isystem.MovieService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.MovieService.dto.comment.CommentCreateDto;
import uz.isystem.MovieService.model.Comment;
import uz.isystem.MovieService.service.CommentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        String response = commentService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid CommentCreateDto comment) {
        Comment response = commentService.create(comment);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody @Valid String comment) {
        Comment response = commentService.update(id, comment);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        String response = commentService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Comment> response = commentService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getByMovie/{id}")
    public ResponseEntity<?> getByMovieID(@PathVariable UUID id){
        return ResponseEntity.ok(commentService.getByMovieId(id));
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable UUID id){
        return ResponseEntity.ok(commentService.getByUserId(id));
    }


}
