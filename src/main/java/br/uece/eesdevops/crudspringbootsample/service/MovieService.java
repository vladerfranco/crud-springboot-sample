package br.uece.eesdevops.crudspringbootsample.service;

import br.uece.eesdevops.crudspringbootsample.entity.Movie;
import br.uece.eesdevops.crudspringbootsample.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

import static java.lang.String.format;

@Service
public class MovieService {

    private MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Movie findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new NoResultException(format("O filme com identificador %s não foi encontrato", id));
        });
    }

    public Movie save(Movie movie){
        return repository.save(movie);
    }
}
