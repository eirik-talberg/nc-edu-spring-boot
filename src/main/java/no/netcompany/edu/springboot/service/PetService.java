package no.netcompany.edu.springboot.service;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.repository.PetRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class PetService {

    private final PetRepository repository;

    public Pet getPetById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Inject
    public PetService(PetRepository repository) {
        this.repository = repository;
    }
}
