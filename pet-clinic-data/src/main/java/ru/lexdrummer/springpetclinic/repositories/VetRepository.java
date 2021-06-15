package ru.lexdrummer.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.lexdrummer.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
