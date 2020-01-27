package no.netcompany.edu.springboot.service;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import no.netcompany.edu.springboot.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
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

    @Test
    public void addPet_savesPetToDatabase() {
        final Pet pet = new Pet();
        pet.setName("Fido");
        pet.setStatus(Status.AVAILABLE);
        pet.setCategory("Dog");

        service.addPet(pet);

        verify(repository).save(pet);
    }

    @Test
    public void deletePet_removesPetFromDatabase() {

        service.deletePet(1L);

        verify(repository).deleteById(1L);
    }

    @Test
    public void findByStatus_returnsAllPetsMatchingStatus() {
        final List<Status> status = Collections.singletonList(Status.AVAILABLE);

        final List<Pet> expected = Collections.singletonList(new Pet());

        when(repository.findByStatus(status)).thenReturn(expected);

        final List<Pet> result = service.findByStatus(status);

        Assertions.assertEquals(expected, result);
        verify(repository).findByStatus(status);
    }
}
