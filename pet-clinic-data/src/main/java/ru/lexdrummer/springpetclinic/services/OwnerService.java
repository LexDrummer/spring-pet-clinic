package ru.lexdrummer.springpetclinic.services;

import ru.lexdrummer.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
