package com.example.stock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "container_types")
public class ContainerType {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "fragile")
    private boolean fragile;

    private String measuringUnit;

    private double capacity;

}
