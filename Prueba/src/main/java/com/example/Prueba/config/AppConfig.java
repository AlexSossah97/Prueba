// Declaración del paquete al que pertenece la clase
package com.example.Prueba.config;

// Importaciones necesarias de Spring Framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Clase de configuración de la aplicación
@Configuration
public class AppConfig {

    // Método que define y configura un bean de tipo RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        // Retorna una nueva instancia de RestTemplate
        return new RestTemplate();
    }
}
