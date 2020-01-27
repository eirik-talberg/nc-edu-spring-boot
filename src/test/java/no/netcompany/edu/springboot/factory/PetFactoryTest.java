package no.netcompany.edu.springboot.factory;

import no.netcompany.edu.springboot.api.model.CategoryDto;
import no.netcompany.edu.springboot.api.model.PetDto;
import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class PetFactoryTest {

    @InjectMocks
    private PetFactory factory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void toPetDto_producesValidObject() {
        final Pet pet = new Pet();
        pet.setId(1L);
        pet.setStatus(Status.AVAILABLE);
        pet.setName("Fido");
        pet.setCategory("Dog");

        final PetDto dto = factory.toPetDto(pet);

        assertEquals(1L, dto.getId());
        assertEquals(PetDto.StatusEnum.AVAILABLE, dto.getStatus());
        assertEquals("Fido", dto.getName());
        assertEquals("Dog", dto.getCategory().getName());
    }

    @Test
    public void toPet_producesValidObject() {
        final PetDto dto = new PetDto()
                .category(new CategoryDto().name("Dog"))
                .name("Fido")
                .status(PetDto.StatusEnum.AVAILABLE);

        final Pet pet = factory.toPet(dto);

        assertNull(pet.getId());
        assertEquals("Dog", pet.getCategory());
        assertEquals(Status.AVAILABLE, pet.getStatus());
        assertEquals("Fido", pet.getName());
    }

}