package no.netcompany.edu.springboot.factory;

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

}