package no.netcompany.edu.springboot.factory;

import no.netcompany.edu.springboot.api.model.CategoryDto;
import no.netcompany.edu.springboot.api.model.PetDto;
import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import org.springframework.stereotype.Component;

@Component
public class PetFactory {

    public PetDto toPetDto(final Pet input) {
        final CategoryDto categoryDto = new CategoryDto()
                .name(input.getCategory());

        final PetDto.StatusEnum statusEnum = PetDto.StatusEnum.fromValue(input.getStatus().getValue());

        return new PetDto()
                .id(input.getId())
                .name(input.getName())
                .category(categoryDto)
                .status(statusEnum);

    }

    public Pet toPet(final PetDto input) {
        final Status status = Status.valueOf(input.getStatus().name());

        final Pet pet = new Pet();
        pet.setName(input.getName());
        pet.setCategory(input.getCategory().getName());
        pet.setStatus(status);

        return pet;
    }
}
