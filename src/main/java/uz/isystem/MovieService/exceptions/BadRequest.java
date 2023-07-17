package uz.isystem.MovieService.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message ){
        super(message);
    }
}
