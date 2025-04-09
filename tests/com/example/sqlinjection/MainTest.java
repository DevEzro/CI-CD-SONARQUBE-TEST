package com.example.sqlinjectiontest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testSumar() {
        int resultado = Main.sumar(2, 3);
        // Imprimir el resultado en los logs
        System.out.println("Resultado de la suma: 2 + 3 = " + resultado);
        assertEquals(5, resultado, "La suma debería ser 5");
    }

    @Test
    public void testSumarNegativos() {
        int resultado = Main.sumar(-2, -3);
        // Imprimir el resultado en los logs
        System.out.println("Resultado de la suma: -2 + -3 = " + resultado);
        assertEquals(-5, resultado, "La suma debería ser -5");
    }
}
