package net.journeyhero.travelapp.repository;

import net.journeyhero.travelapp.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, UUID> {
    @Query(value = "SELECT * FROM attraction WHERE ST_DWithin(location, ST_SetSRAD(ST_MakePoint(:longitude, :latitude), 4326), :distance)", nativeQuery = true)
    List<AttractionEntity> findAttractionsWithinDistance(
            @Param("longitude") double longitude,
            @Param("latitude") double latitude,
            @Param("distance") double distance
    );
}
