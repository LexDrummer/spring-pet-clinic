package ru.lexdrummer.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.lexdrummer.springpetclinic.model.*;
import ru.lexdrummer.springpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Woof");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Meeau");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner michael = new Owner();
        michael.setFirstName("Michael");
        michael.setLastName("Weston");
        michael.setAddress("123 Bleeker st.");
        michael.setCity("London");
        michael.setPhone("+4489432083");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(michael);
        mikesPet.setBirthDate(LocalDate.ofYearDay(2012, 100));
        mikesPet.setName("Rex");
        michael.getPets().add(mikesPet);

        ownerService.save(michael);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Gallagher");
        fiona.setAddress("45 Baker st.");
        fiona.setCity("London");
        fiona.setPhone("+449083495803");
        Pet fionasCat = new Pet();
        fionasCat.setOwner(fiona);
        fionasCat.setName("Fluffy");
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDate(LocalDate.ofYearDay(2015, 30));
        fiona.getPets().add(fionasCat);

        ownerService.save(fiona);

        Visit fionasCatVisit = new Visit();
        fionasCatVisit.setPet(fionasCat);
        fionasCatVisit.setDate(LocalDate.now());
        fionasCatVisit.setDescription("Not eating");
        visitService.save(fionasCatVisit);
        System.out.println("Loaded Owners....");

        Vet sam = new Vet();
        sam.setFirstName("Sam");
        sam.setLastName("Axe");
        sam.getSpecialities().add(savedDentistry);

        vetService.save(sam);

        Vet bob = new Vet();
        bob.setFirstName("Bob");
        bob.setLastName("Dum");
        bob.getSpecialities().add(savedRadiology);

        vetService.save(bob);

        Vet pasha = new Vet();
        pasha.setFirstName("Pashka");
        pasha.setLastName("Otrutskiy");
        vetService.save(pasha);
        pasha.getSpecialities().add(savedSurgery);

        System.out.println("Loaded Vets....");
    }
}
