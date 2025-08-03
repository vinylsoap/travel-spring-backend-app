package net.journeyhero.travelapp.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

import java.util.UUID;

@Entity
@Table(name = "attraction")
public class AttractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "geometry(Point,4326)", nullable = false)
    private Point location;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
