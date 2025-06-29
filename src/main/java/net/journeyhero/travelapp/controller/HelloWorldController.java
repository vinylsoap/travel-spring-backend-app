package net.journeyhero.travelapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.journeyhero.travelapp.dto.Hello;

@RestController 
@RequestMapping(path="/api")
public class HelloWorldController {

	@GetMapping(path="/hello")
	public Hello helloWorld() {
		return new Hello("how are you", "vika");
	}
}
