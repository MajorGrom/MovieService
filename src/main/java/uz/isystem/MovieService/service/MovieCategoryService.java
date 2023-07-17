package uz.isystem.MovieService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.MovieService.dto.MovieCategory.MovieCategoryDto;
import uz.isystem.MovieService.model.Category;
import uz.isystem.MovieService.model.Movie;
import uz.isystem.MovieService.model.MovieCategory;
import uz.isystem.MovieService.repository.MovieCategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieCategoryService {
    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    public MovieCategory create(MovieCategoryDto dto){
        MovieCategory movieCategory = new MovieCategory();
        movieCategory = convertDtoToEntity(dto);
        movieCategoryRepository.save(movieCategory);
        return movieCategory;
    }

    public MovieCategory convertDtoToEntity(MovieCategoryDto dto){
        MovieCategory entity = new MovieCategory();
        Category category = new Category();
        category.setId(dto.getCategoryID());
        //category = new CategoryService().getEntity(dto.getCategoryID());
        entity.setCategory(category);
        entity.setCategoryID(dto.getCategoryID());
        Movie movie = new Movie();
        movie.setId(dto.getMovieID());
        //movie = new MovieService().getEntity(dto.getMovieID());
        entity.setMovie(movie);
        entity.setMovieID(dto.getMovieID());
        return entity;
    }

    public MovieCategoryDto convertEntityToDto(MovieCategory entity){
        MovieCategoryDto dto = new MovieCategoryDto();
        dto.setCategoryID(entity.getCategoryID());
        dto.setMovieID(entity.getMovieID());
        return dto;
    }



    public MovieCategoryDto get(UUID id){
        return convertEntityToDto(getEntity(id));
    }
    public MovieCategory getEntity(UUID id){
        Optional<MovieCategory> optional = movieCategoryRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public MovieCategory update(UUID id, MovieCategoryDto dto){
        MovieCategory  entity = convertDtoToEntity(dto);
        entity.setId(id);
        movieCategoryRepository.save(entity);
        return entity;
    }

    public String delete (UUID id){
        movieCategoryRepository.deleteById(id);
        return "deleted";
    }

    public List<MovieCategory> getAll(){
        return movieCategoryRepository.findAll();
    }
}
