package no.netcompany.edu.springboot.repository;

import no.netcompany.edu.springboot.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {}
