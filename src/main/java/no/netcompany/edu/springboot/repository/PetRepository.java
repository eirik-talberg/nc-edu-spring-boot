package no.netcompany.edu.springboot.repository;

import no.netcompany.edu.springboot.model.Pet;
import no.netcompany.edu.springboot.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p where p.status IN (:statuses)")
    List<Pet> findByStatus(@Param("statuses") final List<Status> statuses);

}
