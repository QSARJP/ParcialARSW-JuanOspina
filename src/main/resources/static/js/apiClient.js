apiclient = (function () {
    return {
        consultarUsuario: function (name, callback) {
            $.ajax({
                method: "GET",
                contentType: "application/json",
                url: "https://localhost:8080/aiports/" + name,
                success: function (respuesta) {
                    callback(respuesta)
                },
                error: function () {
                    console.log("No se ha podido obtener la información");
                }
                });
            }
        }

})();