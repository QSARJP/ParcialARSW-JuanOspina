package edu.eci.arsw.AirportsFinderBackend.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.AirportsFinderBackend.model.Airport;
import edu.eci.arsw.AirportsFinderBackend.cache.AirportPersistenceException;
import edu.eci.arsw.AirportsFinderBackend.cache.AirportsFinderCache;
import edu.eci.arsw.AirportsFinderBackend.services.AirportsFinderServices;


@Service
public class AirportsFinderServicesImpl implements AirportsFinderServices{


	@Autowired
	AirportsFinderCache airportsCache;
	
	@Override
	public Airport[] getAirportByName(String name) throws AirportPersistenceException {
		try { 
			return airportsCache.getNameAirport(name);
		} catch (IOException e) {
			throw new AirportPersistenceException(AirportPersistenceException.CITY_NOT_FOUND); 
		}
		
	}

}
    
