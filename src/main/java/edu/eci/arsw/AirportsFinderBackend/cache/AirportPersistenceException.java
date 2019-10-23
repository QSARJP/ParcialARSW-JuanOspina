package edu.eci.arsw.AirportsFinderBackend.cache;


public class AirportPersistenceException extends Exception {

    public static final String CITY_NOT_FOUND = "City not found";
    public static final String API_NOT_GET = "No se pudo conectar a la api";
    


    public AirportPersistenceException(){
        super();
    }

    public AirportPersistenceException(String msg){
        super(msg);
    }

}