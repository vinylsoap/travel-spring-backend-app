package net.journeyhero.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.journeyhero.travelapp.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
	
}
