package no.netcompany.edu.springboot.repository;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
class PetRepositoryTest {

    @Inject
    private PetRepository petRepository;

    @Inject
    private TestEntityManager entityManager;

    @BeforeEach
    public void setUp() {
        final Pet pet1 = new Pet();
        pet1.setStatus(Status.AVAILABLE);
        pet1.setName("Pet 1");

        final Pet pet2 = new Pet();
        pet2.setStatus(Status.PENDING);
        pet2.setName("Pet 2");

        final Pet pet3 = new Pet();
        pet3.setStatus(Status.SOLD);
        pet3.setName("Pet 3");

        entityManager.persist(pet1);
        entityManager.persist(pet2);
        entityManager.persist(pet3);
        entityManager.flush();
    }

    @Test
    public void findByStatus_returnsAllPetsMatchingGivenStatuses() {

        final List<Pet> result = petRepository.findByStatus(Arrays.asList(Status.AVAILABLE, Status.SOLD));

        Assertions.assertEquals(2, result.size());

        result.forEach(pet -> {
            if (pet.getName().equals("Pet 1")) {
                Assertions.assertEquals(Status.AVAILABLE, pet.getStatus());
            } else {
                Assertions.assertEquals(Status.SOLD, pet.getStatus());
            }
        });
    }

}