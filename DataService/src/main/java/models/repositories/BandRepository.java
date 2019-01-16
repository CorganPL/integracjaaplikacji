package models.repositories;

import models.entities.Band;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {
}
