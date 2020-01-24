package no.netcompany.edu.springboot.api;

import no.netcompany.edu.springboot.api.model.Pet;
import no.netcompany.edu.springboot.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class PetController implements PetApi {

    private final PetService service;

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        final no.netcompany.edu.springboot.model.Pet pet = service.getPetById(petId);

        //TODO: Convert to API model
        return ResponseEntity.ok(null);
    }

    @Inject
    public PetController(PetService service) {
        this.service = service;
    }
}
