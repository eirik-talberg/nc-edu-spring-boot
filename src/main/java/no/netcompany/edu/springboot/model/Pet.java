package no.netcompany.edu.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {

    @GeneratedValue
    @Id
    private Long id;
}
