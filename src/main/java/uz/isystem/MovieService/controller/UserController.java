package uz.isystem.MovieService.controller;


import jakarta.validation.Valid;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.MovieService.dto.user.UserCreateDto;
import uz.isystem.MovieService.dto.user.UserDetailDto;
import uz.isystem.MovieService.model.User;
import uz.isystem.MovieService.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id){
        UserDetailDto response = userService.get(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserCreateDto user){
        User response = userService.create(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody @Valid UserCreateDto user){
        String response = userService.update(id, user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable UUID id){
        String response = userService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<User> response = userService.getAll();
        return ResponseEntity.ok(response);
    }
}
