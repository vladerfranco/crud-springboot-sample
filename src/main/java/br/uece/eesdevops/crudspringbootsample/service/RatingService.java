package br.uece.eesdevops.crudspringbootsample.service;

import br.uece.eesdevops.crudspringbootsample.entity.Rating;
import br.uece.eesdevops.crudspringbootsample.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private RatingRepository repository;

    @Autowired
    public RatingService(RatingRepository repository) {
        this.repository = repository;
    }

    public Rating save(Rating rating) {
        return repository.save(rating);
    }
}
