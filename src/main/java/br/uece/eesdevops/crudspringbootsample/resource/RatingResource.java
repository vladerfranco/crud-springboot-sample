package br.uece.eesdevops.crudspringbootsample.resource;

import br.uece.eesdevops.crudspringbootsample.entity.Rating;
import br.uece.eesdevops.crudspringbootsample.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    private RatingService service;

    @Autowired
    public RatingResource(RatingService service) {
        this.service = service;
    }

}
