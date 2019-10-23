package edu.eci.arsw.AirportsFinderBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.AirportsFinderBackend.services.AirportsFinderServices;



  
@RestController
@RequestMapping(value = "/airports")
public class AirportsFinderController {

	@Autowired
	AirportsFinderServices aiportServices;
	
	@GetMapping(value = "/{name}")
	public ResponseEntity<?> getAirportByName(@PathVariable String name){
		try {
			return new ResponseEntity<>(aiportServices.getAirportByName(name) ,HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
}

