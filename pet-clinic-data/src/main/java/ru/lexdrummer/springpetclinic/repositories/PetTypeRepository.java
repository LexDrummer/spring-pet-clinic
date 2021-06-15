package ru.lexdrummer.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lexdrummer.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
