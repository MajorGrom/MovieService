package uz.isystem.MovieService.service;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.MovieService.dto.user.UserCreateDto;
import uz.isystem.MovieService.dto.user.UserDetailDto;
import uz.isystem.MovieService.enums.UserStatus;
import uz.isystem.MovieService.model.User;
import uz.isystem.MovieService.repository.UserRepository;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserCreateDto dto){
        User entity = new User();
        convertDtoToEntity(dto, entity);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setStatus(UserStatus.INACTIVE);
        userRepository.save(entity);
        return entity;
    }

    public UserDetailDto convertEntityToDto(User entity, UserDetailDto dto){
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAddress(entity.getAddress());
        dto.setEmail(entity.getEmail());
        dto.setBirthDate(entity.getBirthDate());
        dto.setGender(entity.getGender());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public void convertDtoToEntity(UserCreateDto dto, User entity){
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setPassword(dto.getPassword());
        entity.setBirthDate(dto.getBirthDate());
        entity.setGender(dto.getGender());
        entity.setImageURL(dto.getImageURL());
        entity.setCreatedAt(getEntity(dto.getId()).getCreatedAt());
        entity.setUpdatedAt(LocalDateTime.now());
    }

    public UserDetailDto get(UUID id){
        UserDetailDto dto = new UserDetailDto();

        User user = getEntity(id);

        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setAddress(user.getAddress());
        dto.setBirthDate(user.getBirthDate());
        dto.setGender(user.getGender());
        dto.setStatus(user.getStatus());

        return dto;
    }

    public String update(UUID id, UserCreateDto dto){
        User entity = new User();
        convertDtoToEntity(dto, entity);
        userRepository.save(entity);
        return "Updated successfully";
    }

    public String delete (UUID id){
        userRepository.deleteById(id);
        return "deleted";
    }

    public User getEntity(UUID id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }



    public List<User> getAll(){
        return userRepository.findAll();
    }
}
