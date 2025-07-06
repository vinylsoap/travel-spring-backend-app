package net.journeyhero.travelapp.repository;

import net.journeyhero.travelapp.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, UUID> {

}
