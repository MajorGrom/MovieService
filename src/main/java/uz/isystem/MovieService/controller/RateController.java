package uz.isystem.MovieService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.MovieService.model.Category;
import uz.isystem.MovieService.model.Rate;
import uz.isystem.MovieService.service.RateService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rate")

public class RateController {
    @Autowired
    RateService rateService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        Rate response = rateService.getEntity(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid Rate rate) {
        Rate response = rateService.create(rate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAverageRate/{id}")
    public ResponseEntity<?> getAverageRate(@PathVariable UUID id){
        float response = rateService.getAverageRate(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/{rate}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @PathVariable Integer rate) {
        Rate response = rateService.update(id, rate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        String response = rateService.delete(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Rate> response = rateService.getAll();
        return ResponseEntity.ok(response);
    }
}
