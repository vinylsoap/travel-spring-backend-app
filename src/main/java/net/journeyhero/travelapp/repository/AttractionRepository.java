package net.journeyhero.travelapp.repository;

import net.journeyhero.travelapp.entity.AttractionEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, UUID> {
    @Query(value = """
            SELECT a FROM AttractionEntity a
            WHERE function('ST_DWithin', a.location, :point, :distance, true) = true
            ORDER BY function('ST_Distance', a.location, :point) ASC
            """)
    Page<AttractionEntity> findAttractionsWithinDistance(
            @Param("point") Point point,
            @Param("distance") double distance,
            Pageable pageable
    );
}
