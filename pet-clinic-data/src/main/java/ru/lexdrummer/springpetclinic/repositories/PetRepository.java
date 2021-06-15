package ru.lexdrummer.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lexdrummer.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
