package org.example.city.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// lombok
@Getter @Setter
// JPA
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 300)
    private String name;

    @Column(length = 6)
    private String zipcode;
}
