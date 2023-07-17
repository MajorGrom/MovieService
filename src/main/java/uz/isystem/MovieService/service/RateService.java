package uz.isystem.MovieService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.MovieService.model.Rate;
import uz.isystem.MovieService.repository.RateRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RateService {
    @Autowired
    RateRepository rateRepository;

    public Rate create(Rate rate){
        rateRepository.save(rate);
        return rate;
    }
    public Float getAverageRate(UUID id){
        return rateRepository.getAvgID(id);
    }

    public Rate getEntity(UUID id){
        Optional<Rate> optional = rateRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        return optional.get();
    }

    public Rate update(UUID id, Integer rate){
        Rate rated = getEntity(id);

        rated.setRate(rate);
        rateRepository.save(rated);

        return rated;
    }

    public String delete (UUID id){
        rateRepository.deleteById(id);
        return "deleted";
    }

//    public Float getMovieRate(UUID id){
//        Float rate = rateRepository.getAvgID(id);
//        return rate;
//    }
    public List<Rate> getAll(){
        return rateRepository.findAll();
    }
}
