package uz.isystem.MovieService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.MovieService.dto.movie.MovieCreateDto;
import uz.isystem.MovieService.dto.movie.MovieDetailDto;
import uz.isystem.MovieService.model.Movie;
import uz.isystem.MovieService.repository.MovieRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie create(MovieCreateDto dto){
        Movie movie = new Movie();
        ConvertDtoToEntity(dto, movie);
        movie.setCreatedAt(LocalDateTime.now());
        movieRepository.save(movie);
        return movie;
    }

    public MovieDetailDto ConvertEntityToDTo(Movie entity){
        MovieDetailDto dto = new MovieDetailDto();
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPublishedAt(entity.getPublishedAt());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public void ConvertDtoToEntity(MovieCreateDto dto, Movie entity){
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPublishedAt(dto.getPublishedAt());
    }

    public MovieDetailDto get(UUID id){
        Movie entity = getEntity(id);
        return ConvertEntityToDTo(entity);
    }

    public Movie getEntity(UUID id){
        Optional<Movie> optional = movieRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }






    public Movie update(UUID id, MovieCreateDto dto){
        Movie movie = new Movie();
        ConvertDtoToEntity(dto, movie);
        movie.setId(id);
        movie.setCreatedAt(get(id).getCreatedAt());
        movie.setUpdatedAt(LocalDateTime.now());
        movieRepository.save(movie);
        return movie;
    }

    public String delete (UUID id){
        movieRepository.deleteById(id);
        return "deleted";
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }
}
