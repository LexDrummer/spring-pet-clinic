package ru.lexdrummer.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.lexdrummer.springpetclinic.model.Owner;
import ru.lexdrummer.springpetclinic.model.Vet;
import ru.lexdrummer.springpetclinic.services.OwnerService;
import ru.lexdrummer.springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gallagher");

        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bob");
        vet2.setLastName("Dum");

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Pashka");
        vet3.setLastName("Otrutskiy");
        vetService.save(vet3);
        System.out.println("Loaded Vets....");
    }
}