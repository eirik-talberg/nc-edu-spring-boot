package no.netcompany.edu.springboot;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import no.netcompany.edu.springboot.repository.PetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootApplicationWithTestData {

    private final PetRepository repository;

    public static void main(final String ... args) {
        SpringApplication.run(SpringBootApplicationWithTestData.class, args);
    }

    @EventListener
    public void addDummyData(final ApplicationReadyEvent event) {

        IntStream.of(10)
                .mapToObj(i -> createPet())
                .forEach(repository::save);
    }

    private static Pet createPet() {
        final var pet =  new Pet();

        pet.setCategory("Dog");
        pet.setName("Fido");
        pet.setStatus(Status.AVAILABLE);

        return pet;
    }

    @Inject
    public SpringBootApplicationWithTestData(final PetRepository repository) {
        this.repository = repository;
    }

}
