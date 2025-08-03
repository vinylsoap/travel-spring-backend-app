package net.journeyhero.travelapp.dto;

import net.journeyhero.travelapp.entity.DisabilityType;
import net.journeyhero.travelapp.entity.RatingLevel;

import java.util.UUID;


public class AttractionRatingRequestDto {
    private UUID ratingId;

    private String attractionName;
    private double attractionLongitude;
    private double attractionLatitude;
    private DisabilityType disabilityType;
    private RatingLevel ratingLevel;

    public UUID getRatingId() {
        return ratingId;
    }

    public void setRatingId(UUID ratingId) {
        this.ratingId = ratingId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public double getAttractionLongitude() {
        return attractionLongitude;
    }

    public void setAttractionLongitude(double attractionLongitude) {
        this.attractionLongitude = attractionLongitude;
    }

    public double getAttractionLatitude() {
        return attractionLatitude;
    }

    public void setAttractionLatitude(double attractionLatitude) {
        this.attractionLatitude = attractionLatitude;
    }

    public DisabilityType getDisabilityType() {
        return disabilityType;
    }

    public void setDisabilityType(DisabilityType disabilityType) {
        this.disabilityType = disabilityType;
    }

    public RatingLevel getRatingLevel() {
        return ratingLevel;
    }

    public void setRatingLevel(RatingLevel ratingLevel) {
        this.ratingLevel = ratingLevel;
    }
}
