package com.github.Sangarru11.Calculadora5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Suma dos numeros")
    void testSumar(){
        assertEquals(4,miCalculadora.suma(2,2));
        assertEquals(8,miCalculadora.suma(4,4));
        assertEquals(12,miCalculadora.suma(6,6));
        assertEquals(20,miCalculadora.suma(10,10));
    }

    @Test
    @DisplayName("Resta dos numeros")
    void testRestar(){
        assertEquals(4,miCalculadora.resta(8,4));
        assertEquals(6,miCalculadora.resta(12,6));
        assertEquals(1,miCalculadora.resta(11,10));
        assertEquals(30,miCalculadora.resta(50,20));
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
        assertEquals(16, miCalculadora.multiplica(4,4));
        assertEquals(-5, miCalculadora.multiplica(-5,1));
    }



    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }
    @Test
    @DisplayName("Potencia con diferentes casos")
    void testPotencia() {
        assertEquals(16, miCalculadora.potencia(4, 2));
        assertEquals(0.25, miCalculadora.potencia(2, -2));
        assertEquals(1, miCalculadora.potencia(10, 0));
        assertEquals(9, miCalculadora.potencia(-3, 2));
        assertEquals(-8, miCalculadora.potencia(-2, 3));
    }

    @Test
    @DisplayName("Raiz Cuadrada")
    void testRaizCuadrada() throws Calculadora.OperacionInvalidaException {
        assertEquals(2, miCalculadora.raizCuadrada(4));
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
        assertEquals(3, miCalculadora.raizCuadrada(-9));
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }
}
