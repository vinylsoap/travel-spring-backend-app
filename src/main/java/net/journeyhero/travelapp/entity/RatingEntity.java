package net.journeyhero.travelapp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "rating")
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisabilityType disabilityType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RatingLevel ratingLevel;

    @ManyToOne
    @JoinColumn(nullable = false, name = "attraction_id")
    private AttractionEntity attraction;

    public RatingLevel getRatingLevel() {
        return ratingLevel;
    }

    public void setRatingLevel(RatingLevel ratingLevel) {
        this.ratingLevel = ratingLevel;
    }

    public AttractionEntity getAttraction() {
        return attraction;
    }

    public void setAttraction(AttractionEntity attraction) {
        this.attraction = attraction;
    }

    public DisabilityType getDisabilityType() {
        return disabilityType;
    }

    public void setDisabilityType(DisabilityType disabilityType) {
        this.disabilityType = disabilityType;
    }
}
