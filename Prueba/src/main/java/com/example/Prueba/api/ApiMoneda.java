// Declaración del paquete al que pertenece la clase
package com.example.Prueba.api;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
// Importaciones de clases necesarias
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


// Sevice indica que esta clase es un servicio de Spring Boot
@Service
public class ApiMoneda {
     @Value("${apimoneda-url}") // Inyección de valores de la properties
    // URL de la API a la que se realizarán las solicitudes
    private final String apiUrl = "https://165.227.94.139/api";

    // Instancia de RestTemplate, que se utilizará para realizar solicitudes
    private final RestTemplate restTemplate;

    // Constructor de la clase que recibe una instancia de RestTemplate mediante inyección de dependencias
    public ApiMoneda(RestTemplate restTemplate) {
        // Inicialización del miembro restTemplate con la instancia proporcionada
        this.restTemplate = restTemplate;
    }

    public String obtenerDatosDeLaApi() {
        // Realiza una solicitud GET a la API y obtiene la respuesta como una cadena
        String resultado = restTemplate.getForObject(apiUrl, String.class);

        // Retorna el resultado obtenido
        return resultado;
    }
    public Double obtenerTasaCambioEnFecha(String fecha) {
        String url = apiUrl + "?date=" + fecha;
        JsonNode response = restTemplate.getForObject(apiUrl, JsonNode.class,fecha);

        // Extraer el valor de la tasa de cambio de la UF del JSON
        if (response != null && response.has("valor")) {
            return response.get("valor").asDouble();
        }

        return null;
    }

    // Método para comparar porcentaje de variación entre dos fechas
    public Double calcularVariacionPorcentual(String fechaInicio, String fechaFin) {
        Double tasaInicio = obtenerTasaCambioEnFecha(fechaInicio);
        Double tasaFin = obtenerTasaCambioEnFecha(fechaFin);
        return ((tasaFin - tasaInicio) / tasaInicio) * 100.0;
    }

    // Método para calcular la diferencia en pesos entre dos fechas
    public Double calcularDiferenciaEnPesos(String fechaInicio, String fechaFin, Double monto) {
        Double tasaInicio = obtenerTasaCambioEnFecha(fechaInicio);
        Double tasaFin = obtenerTasaCambioEnFecha(fechaFin);
        return (tasaFin - tasaInicio) * monto;
    }



}
