// Declaración del paquete al que pertenece la clase
package com.example.Prueba.controller;

// Importación de clases necesarias de Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Prueba.api.ApiMoneda;

// Declaración de la clase ApiController que actua como controlador REST
@RestController
public class ApiController {

    // Declaración de un miembro de la clas para contener una instancia de ApiMoneda
    private final ApiMoneda apiMoneda;

    // Constructor de la clase anotado con @Autowired para inyección de dependencias
    @Autowired
    public ApiController(ApiMoneda apiMoneda) {
        // Inicialización del miembro apiMoneda con la instancia proporcionada al constructor
        this.apiMoneda = apiMoneda;
    }

    // Método mapeado a la ruta /consumir-api y asociado a peticiones HTTP GET
    @GetMapping("/consumir-api")
    public String consumirApi() {
        // Llamada al método obtenerDatosDeLaApi() de la instancia apiMoneda
        // para consumir la API y devolver el resultado como una cadena
        return apiMoneda.obtenerDatosDeLaApi();
    }
}
