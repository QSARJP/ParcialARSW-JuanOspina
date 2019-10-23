package edu.eci.arsw.AirportsFinderBackend.services;

import edu.eci.arsw.AirportsFinderBackend.model.Airport;
import edu.eci.arsw.AirportsFinderBackend.cache.AirportPersistenceException;

public interface AirportsFinderServices{


    public Airport[] getAirportByName(String city) throws AirportPersistenceException ;
} 