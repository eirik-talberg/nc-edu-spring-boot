package no.netcompany.edu.springboot.factory;

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
        // Create the input object

        // Call the factory

        // Verify the result
    }

}