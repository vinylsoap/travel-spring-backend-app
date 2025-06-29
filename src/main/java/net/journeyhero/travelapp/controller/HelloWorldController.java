package net.journeyhero.travelapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.journeyhero.travelapp.dto.Hello;
import net.journeyhero.travelapp.entity.BookEntity;
import net.journeyhero.travelapp.repository.BookRepository;

@RestController 
@RequestMapping(path="/api")
public class HelloWorldController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping(path="/hello")
	public Hello helloWorld() {
		return new Hello("how are you", "vika");
	}
	
	@GetMapping(path="/books")
	public List<BookEntity> getBooks() {
		return bookRepository.findAll();
	}
	
	@PostMapping(path="/books")
	public BookEntity saveBook(@RequestBody BookEntity newBook) {
		return bookRepository.save(newBook);
	}
}
