package net.journeyhero.travelapp.controller;

import net.journeyhero.travelapp.dto.AttractionRatingRequestDto;
import net.journeyhero.travelapp.entity.AttractionEntity;
import net.journeyhero.travelapp.entity.RatingEntity;
import net.journeyhero.travelapp.repository.AttractionRepository;
import net.journeyhero.travelapp.repository.RatingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AttractionController {
    private final AttractionRepository attractionRepository;
    private final RatingRepository ratingRepository;

    public AttractionController(AttractionRepository attractionRepository,
                                RatingRepository ratingRepository) {
        this.attractionRepository = attractionRepository;
        this.ratingRepository = ratingRepository;
    }

    @GetMapping(path = "/attraction")
    public List<AttractionEntity> getAttractions(@RequestParam double searchPointLongitude,
                                                 @RequestParam double searchPointLatitude,
                                                 @RequestParam(required = false, defaultValue = "5") double searchDistanceKm) {
        return attractionRepository.findAll();
    }

    @Transactional
    @PostMapping(path = "/attraction")
    public AttractionEntity saveAttraction(@RequestBody AttractionRatingRequestDto ratingRequest) {
        AttractionEntity attraction = new AttractionEntity();
        attraction.setName(ratingRequest.getAttractionName());
        attraction.setLongitude(ratingRequest.getAttractionLongitude());
        attraction.setLatitude(ratingRequest.getAttractionLatitude());
        attractionRepository.save(attraction);

        RatingEntity rating = new RatingEntity();
        rating.setAttraction(attraction);
        rating.setDisabilityType(ratingRequest.getDisabilityType());
        rating.setRatingLevel(ratingRequest.getRatingLevel());
        ratingRepository.save(rating);

        return attraction;
    }
}
