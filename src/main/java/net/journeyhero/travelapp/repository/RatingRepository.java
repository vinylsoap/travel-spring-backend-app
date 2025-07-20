package net.journeyhero.travelapp.repository;

import net.journeyhero.travelapp.entity.RatingEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, UUID> {
    @Query(value = """
            SELECT r FROM RatingEntity r
            LEFT JOIN AttractionEntity a
            ON r.attraction = a
            WHERE function('ST_DWithin', a.location, :point, :distance, true) = true
            ORDER BY function('ST_Distance', a.location, :point) ASC
            """)
    List<RatingEntity> findRatingsWithinDistance(
            @Param("point") Point point,
            @Param("distance") double distance
    );
}
