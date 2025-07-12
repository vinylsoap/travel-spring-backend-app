package net.journeyhero.travelapp.repository;

import net.journeyhero.travelapp.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, UUID> {
    @Query(value = """
            SELECT r.* FROM journeyhero_schema.rating r 
            LEFT JOIN journeyhero_schema.attraction a 
            ON r.attraction_id = a.id 
            WHERE ST_DWithin(a.location, ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326), :distance, true)
            """, nativeQuery = true)
    List<RatingEntity> findRatingsWithinDistance(
            @Param("longitude") double longitude,
            @Param("latitude") double latitude,
            @Param("distance") double distance
    );
}
