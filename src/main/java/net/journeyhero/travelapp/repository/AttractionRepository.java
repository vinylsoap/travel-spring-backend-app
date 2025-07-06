package net.journeyhero.travelapp.repository;

import net.journeyhero.travelapp.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, UUID> {
}
