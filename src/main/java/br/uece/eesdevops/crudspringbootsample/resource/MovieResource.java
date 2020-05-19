package br.uece.eesdevops.crudspringbootsample.resource;

import br.uece.eesdevops.crudspringbootsample.entity.Movie;
import br.uece.eesdevops.crudspringbootsample.entity.Rating;
import br.uece.eesdevops.crudspringbootsample.service.MovieService;
import br.uece.eesdevops.crudspringbootsample.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieResource {

    private MovieService service;
    private RatingService ratingService;

    @Autowired
    public MovieResource(MovieService service, RatingService ratingService) {
        this.service = service;
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        return ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        return ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        return created(URI.create(format("/movies/%s", service.save(movie).getId()))).build();
    }

    @PostMapping(path = "/{id}/ratings")
    public ResponseEntity<Rating> saveRatingOfMovie(@PathVariable Long id, @RequestBody Rating rating) {
        rating.setMovie(service.findById(id));
        return created(URI.create(format("/ratings/%s", ratingService.save(rating).getId()))).build();
    }
}