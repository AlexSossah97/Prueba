package com.example.Prueba.api;

import java.util.Scanner;
import org.springframework.web.client.RestTemplate;

public class CalculadoraMoneda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el año (formato yyyy): ");
        String year = scanner.nextLine();

        System.out.print("Ingrese el mes (formato MM): ");
        String mes = scanner.nextLine();

        // Construye la fecha de inicio y fin del mes
        String fechaInicio = year + "-" + mes + "-01";
        String fechaFin = year + "-" + mes + "-30"; // Asumiendo un mes "completo"

        // Calcula la variación porcentual y la diferencia en pesos utilizando la clase ApiMoneda
        ApiMoneda apiMoneda = new ApiMoneda(new RestTemplate());
        Double variacionPorcentual = apiMoneda.calcularVariacionPorcentual(fechaInicio, fechaFin);
        Double diferenciaEnPesos = apiMoneda.calcularDiferenciaEnPesos(fechaInicio, fechaFin, 1.0); // Asumiendo un monto de 1

        System.out.println("Variación Porcentual: " + variacionPorcentual + "%");
        System.out.println("Diferencia en Pesos: " + diferenciaEnPesos);

        scanner.close();
    }
}