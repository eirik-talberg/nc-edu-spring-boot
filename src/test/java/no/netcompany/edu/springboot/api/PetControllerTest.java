package no.netcompany.edu.springboot.api;

import no.netcompany.edu.springboot.api.model.CategoryDto;
import no.netcompany.edu.springboot.api.model.PetDto;
import no.netcompany.edu.springboot.factory.PetFactory;
import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PetControllerTest {

    @InjectMocks
    private PetController controller;

    @Mock
    private PetService petService;

    @Mock
    private PetFactory petFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPetById_returnsPet() {
        final Pet pet = new Pet();

        final PetDto petDto = new PetDto()
                .category(new CategoryDto().name("Dog"))
                .status(PetDto.StatusEnum.AVAILABLE)
                .name("Fido")
                .id(1L);

        when(petService.getPetById(1L)).thenReturn(pet);
        when(petFactory.toPetDto(pet)).thenReturn(petDto);

        final ResponseEntity<PetDto> response = controller.getPetById(1L);
        assertEquals(petDto, response.getBody());
        verify(petService).getPetById(1L);
        verify(petFactory).toPetDto(pet);
    }

    @Test
    public void addPet_returnsOk() {
        final PetDto petDto = new PetDto();

        final Pet pet = new Pet();

        when(petFactory.toPet(petDto)).thenReturn(pet);

         final ResponseEntity<Void> response = controller.addPet(petDto);

         assertEquals(HttpStatus.OK, response.getStatusCode());
         verify(petFactory).toPet(petDto);
         verify(petService).addPet(pet);
    }
}