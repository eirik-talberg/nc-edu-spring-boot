package no.netcompany.edu.springboot.service;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import no.netcompany.edu.springboot.repository.PetRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PetService {

    private final PetRepository repository;

    public Pet getPetById(final Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public void addPet(final Pet pet) {
        repository.save(pet);
    }

    public void deletePet(final Long id) {
        repository.deleteById(id);
    }

    public List<Pet> findByStatus(final List<Status> status) {
        return repository.findByStatus(status);
    }

    @Inject
    public PetService(final PetRepository repository) {
        this.repository = repository;
    }
}
