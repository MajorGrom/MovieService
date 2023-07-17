package uz.isystem.MovieService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.MovieService.dto.comment.CommentCreateDto;
import uz.isystem.MovieService.model.Comment;
import uz.isystem.MovieService.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment create(CommentCreateDto dto){

        Comment entity = new Comment();
        ConvertDtoToEntity(dto,entity);

        entity.setCreatedAt(LocalDateTime.now());
        commentRepository.save(entity);
        return entity;
    }

    public Comment getEntity(UUID id){
        Optional<Comment> optional = commentRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public void ConvertDtoToEntity( CommentCreateDto dto, Comment entity){
        entity.setComment(dto.getComment());
        entity.setMovieId(dto.getMovieId());
        entity.setUserId(dto.getUserId());
    }

    public String get(UUID id){
        return getEntity(id).getComment();
    }

    public Comment update(UUID id, String comment){
        Comment entity = new Comment();
        Comment oldEntity = getEntity(id);

        entity.setId(id);
        entity.setComment(comment);
        entity.setMovieId(oldEntity.getMovieId());
        entity.setUserId(oldEntity.getUserId());
        entity.setCreatedAt(oldEntity.getCreatedAt());
        entity.setUpdatedAt(LocalDateTime.now());

        commentRepository.save(entity);
        return entity;
    }

    public String delete (UUID id){
        commentRepository.deleteById(id);
        return "deleted";
    }

    public List<Comment> getByMovieId(UUID id){
        return commentRepository.findByMovieId(id);
    }

    public List<Comment> getByUserId(UUID id){
        return commentRepository.findByUserId(id);
    }

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }
}
