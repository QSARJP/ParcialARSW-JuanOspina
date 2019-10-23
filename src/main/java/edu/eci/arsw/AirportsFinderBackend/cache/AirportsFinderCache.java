package edu.eci.arsw.AirportsFinderBackend.cache;


import java.io.IOException;

import edu.eci.arsw.AirportsFinderBackend.model.Airport;

public interface AirportsFinderCache {
	public Airport[] getNameAirport(String city) throws IOException;
}