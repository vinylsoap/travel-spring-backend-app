package net.journeyhero.travelapp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "attraction")
public class AttractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private double latitude;
}
