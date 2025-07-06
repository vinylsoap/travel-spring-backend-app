package net.journeyhero.travelapp.controller;

import net.journeyhero.travelapp.entity.AttractionEntity;
import net.journeyhero.travelapp.repository.AttractionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AttractionController {
    private final AttractionRepository attractionRepository;

    public AttractionController(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @GetMapping(path = "/attraction")
    public List<AttractionEntity> getAttractions(@RequestParam double searchPointLongitude,
                                                 @RequestParam double searchPointLatitude,
                                                 @RequestParam(required = false, defaultValue = "5") double searchDistanceKm) {
        return attractionRepository.findAll();
    }

    @PostMapping(path = "/attraction")
    public AttractionEntity saveAttraction(@RequestBody AttractionEntity newBook) {
        return attractionRepository.save(newBook);
    }
}
