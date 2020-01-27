package no.netcompany.edu.springboot.api;

import no.netcompany.edu.springboot.api.model.PetDto;
import no.netcompany.edu.springboot.factory.PetFactory;
import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class PetController implements PetApi {

    private final PetService service;
    private final PetFactory factory;

    @Override
    public ResponseEntity<PetDto> getPetById(final Long petId) {
        final Pet pet = service.getPetById(petId);

        final PetDto dto = factory.toPetDto(pet);

        return ResponseEntity.ok(dto);
    }

    @Inject
    public PetController(final PetService service, final PetFactory factory) {
        this.service = service;
        this.factory = factory;
    }
}
