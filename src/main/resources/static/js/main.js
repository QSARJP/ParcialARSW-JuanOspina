var api = apiclient;
appMapa = (function () {

    var nameAirport;


    var cambiarNombre = function(name) {
        nameAirport = name;
      };
    
    var mapPoints = function(airports) {
        return airports.map(function(airport) {
          return { name: airport.name, longitude: airport.location.longitude,latitude: airport.location.latitude };
        });
      };

    var generatetable = function(airports) {
        airports = mapPoints(airports);
        $("#tablas").empty(); 
        airports.map(function(airport) {
          $("#tablas").append(
            "<tr> <td>" +
                airport.name +
              "</td> <td>" +
              airport.location.longitude +
              "</td>  <td>" +
              airport.location.latitude +
              "</td> "
          );
        });
      };

      var actualizar = function(name) {
        cambiarNombre(name);
        $("#name").text(name);
        api.consultarUsuario(name, generatetable);
        
      };


    return {
        actualizar: actualizar
      };

})();

