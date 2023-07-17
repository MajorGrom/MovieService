package uz.isystem.MovieService.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import uz.isystem.MovieService.dto.category.CategoryDto;
import uz.isystem.MovieService.model.Category;
import uz.isystem.MovieService.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category create(CategoryDto dto){
        Category category = new Category();
        category.setName(dto.getName());
        categoryRepository.save(category);
        return category;
    }

    public CategoryDto get(UUID id){
        CategoryDto dto = new CategoryDto();
        dto.setName(getEntity(id).getName());
        return dto;
    }
    public Category getEntity(UUID id){
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public Category update(UUID id, CategoryDto dto){
        Category category = new Category();
        category.setName(dto.getName());
        category.setId(id);
        categoryRepository.save(category);
        return category;
    }


    public String delete (UUID id){
        categoryRepository.deleteById(id);
        return "deleted";
    }


    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

//    public List<Category> getAll(){
//        return categoryRepository.findAll();
//    }
}