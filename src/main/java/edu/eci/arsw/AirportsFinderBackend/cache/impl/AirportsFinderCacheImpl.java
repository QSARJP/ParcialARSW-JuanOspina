package edu.eci.arsw.AirportsFinderBackend.cache.impl;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arsw.AirportsFinderBackend.connection.HttpConnectionService;
import edu.eci.arsw.AirportsFinderBackend.model.Airport;
import edu.eci.arsw.AirportsFinderBackend.cache.AirportsFinderCache;

@Component
public class AirportsFinderCacheImpl implements AirportsFinderCache {

	@Autowired
	HttpConnectionService connectionService;

	ConcurrentHashMap<String, Airport[]> aeropuertos = new ConcurrentHashMap<>();

	ConcurrentHashMap<String, Long> tiempoAeropuertos = new ConcurrentHashMap<>();

	@Override
	public Airport[] getNameAirport(String name) throws IOException {
		long minutos = 5;
		long tiempoCache = 1000000000 * minutos;
		if (tiempoAeropuertos.contains(name)) {
			long tiempo = System.nanoTime() - tiempoAeropuertos.get(name);
			if (tiempo > tiempoCache) {
				Airport[] airport = ApiConnection(name);
				Long newTime = System.nanoTime();
				aeropuertos.replace(name, airport);
				tiempoAeropuertos.replace(name, newTime);
				return airport;
			} else {
				return aeropuertos.get(name);
			}
		} else {
			Airport[] newAirport = ApiConnection(name);
			Long  newTime = System.nanoTime();
			aeropuertos.put(name, newAirport);
			tiempoAeropuertos.put(name, newTime);
			return newAirport;
		}
	}


	private Airport[] ApiConnection(String name) throws IOException{

		String data = connectionService.getHttpConnection(name);
		Airport[] airport = new Gson().fromJson(data,Airport[].class);
			
		System.out.println("Latitud "+ airport[0].getLocation().getLatitude());

		return airport;

	}
	
	
	
	
}