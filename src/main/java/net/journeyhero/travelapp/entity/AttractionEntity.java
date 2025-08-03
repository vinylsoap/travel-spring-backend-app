package net.journeyhero.travelapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "attraction")
public class AttractionEntity extends AuditedEntity {


    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "geometry(Point,4326)", nullable = false)
    private Point location;


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
