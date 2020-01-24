package no.netcompany.edu.springboot.repository;

import no.netcompany.edu.springboot.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {}
