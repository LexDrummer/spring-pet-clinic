package ru.lexdrummer.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lexdrummer.springpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
