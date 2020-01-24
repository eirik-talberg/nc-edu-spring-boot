package no.netcompany.edu.springboot.service;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


import static org.mockito.Mockito.when;

public class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private PetRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPetById_returnsPetWithMatchingId() {
        when(repository.findById(1L)).thenReturn(Optional.of(new Pet()));

        final Pet pet = service.getPetById(1L);

        Assertions.assertNotNull(pet);
    }

    @Test
    public void getPetById_returnsNull_whenPetDoesNotExist() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        final Pet pet = service.getPetById(1L);

        Assertions.assertNull(pet);
    }
}
