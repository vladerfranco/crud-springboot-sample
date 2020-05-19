package br.uece.eesdevops.crudspringbootsample.repository;

import br.uece.eesdevops.crudspringbootsample.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
