package net.journeyhero.travelapp.controller;

import net.journeyhero.travelapp.dto.AttractionRatingRequestDto;
import net.journeyhero.travelapp.entity.AttractionEntity;
import net.journeyhero.travelapp.entity.RatingEntity;
import net.journeyhero.travelapp.repository.AttractionRepository;
import net.journeyhero.travelapp.repository.RatingRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Transactional
@RestController
@RequestMapping(path = "/api")
public class AttractionController {
    public static final int SRID = 4326;
    public static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(), SRID);

    private final AttractionRepository attractionRepository;
    private final RatingRepository ratingRepository;

    public AttractionController(AttractionRepository attractionRepository,
                                RatingRepository ratingRepository) {
        this.attractionRepository = attractionRepository;
        this.ratingRepository = ratingRepository;
    }

    @GetMapping(path = "/attraction")
    public Page<RatingEntity> getAttractionRatings(@RequestParam double searchPointLongitude,
                                                   @RequestParam double searchPointLatitude,
                                                   @RequestParam(required = false, defaultValue = "5") double searchDistanceKm,
                                                   @RequestParam(required = false, defaultValue = "0") int pageNumber,
                                                   @RequestParam(required = false, defaultValue = "25") int pageSize) {
        Point point = GEOMETRY_FACTORY.createPoint(new Coordinate(searchPointLongitude, searchPointLatitude));
        return ratingRepository.findRatingsWithinDistance(point, searchDistanceKm * 1000, PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping(path = "/attraction")
    public AttractionEntity saveAttractionRating(@RequestBody AttractionRatingRequestDto ratingRequest) {
        Point location = GEOMETRY_FACTORY.createPoint(new Coordinate(ratingRequest.getAttractionLongitude(), ratingRequest.getAttractionLatitude()));
        AttractionEntity attraction = new AttractionEntity();
        attraction.setName(ratingRequest.getAttractionName());
        attraction.setLocation(location);
        attractionRepository.save(attraction);

        RatingEntity rating = new RatingEntity();
        rating.setAttraction(attraction);
        rating.setDisabilityType(ratingRequest.getDisabilityType());
        rating.setRatingLevel(ratingRequest.getRatingLevel());
        ratingRepository.save(rating);

        return attraction;
    }

    @PutMapping(path = "/attraction/{ratingId}")
    public RatingEntity updateAttractionRating(@PathVariable UUID ratingId, @RequestBody AttractionRatingRequestDto request) {
        RatingEntity rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        rating.setRatingLevel(request.getRatingLevel());
        rating.setDisabilityType(request.getDisabilityType());

        AttractionEntity attraction = rating.getAttraction();
        attraction.setName(request.getAttractionName());
        Point newLocation = GEOMETRY_FACTORY.createPoint(new Coordinate(request.getAttractionLongitude(), request.getAttractionLatitude()));
        attraction.setLocation(newLocation);

        return ratingRepository.save(rating);
    }

    @DeleteMapping(path = "/attraction/{ratingId}")
    public void deleteAttractionRating(@PathVariable UUID ratingId) {
        String currentUserId = SecurityContextHolder.getContext().getAuthentication().getName();
        RatingEntity rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (rating.getCreatedBy().equals(currentUserId)) {
            ratingRepository.deleteById(ratingId);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
