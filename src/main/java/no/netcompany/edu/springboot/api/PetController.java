package no.netcompany.edu.springboot.api;

import no.netcompany.edu.springboot.api.model.PetDto;
import no.netcompany.edu.springboot.factory.PetFactory;
import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import no.netcompany.edu.springboot.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

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


    @Override
    public ResponseEntity<Void> addPet(@Valid final PetDto body) {
        final Pet newPet = factory.toPet(body);

        service.addPet(newPet);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PetDto>> findPetsByStatus(@NotNull @Valid final List<String> status) {
        final List<Status> requestedStatuses = status.stream()
                .map(s -> Status.valueOf(PetDto.StatusEnum.fromValue(s).name()))
                .collect(Collectors.toList());

        final List<Pet> pets = service.findByStatus(requestedStatuses);

        final List<PetDto> result = pets.stream()
                .map(factory::toPetDto)
                .collect(Collectors.toList());


        return ResponseEntity.ok(result);
    }

    @Inject
    public PetController(final PetService service, final PetFactory factory) {
        this.service = service;
        this.factory = factory;
    }
}
