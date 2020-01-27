package no.netcompany.edu.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


}
