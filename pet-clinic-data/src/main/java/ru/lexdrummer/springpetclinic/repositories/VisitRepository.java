package ru.lexdrummer.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lexdrummer.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
