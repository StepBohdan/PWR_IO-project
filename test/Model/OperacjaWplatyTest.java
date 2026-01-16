package Model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperacjaWplatyTest {

    private static OperacjaWplaty operacjaWplaty;
    private static Klient klient;

    @BeforeAll
    static void setUp() {
        klient = new Klient(1, "Jan", "Kowalski", "Nowak", 1000.0f);
        operacjaWplaty = new OperacjaWplaty("12345", klient);
    }

    @AfterAll
    static void tearDown() {
        klient = null;
        operacjaWplaty = null;
    }

    @Test
    @DisplayName("Should return operation number")
    void dajNrOperacji() {
        // When
        String operationId = operacjaWplaty.dajNrOperacji();
        
        // Then
        assertEquals("12345", operationId);
    }

    @Test
    @DisplayName("Should return client")
    void dajKlienta() {
        // When
        Klient expectedClient = operacjaWplaty.dajKlienta();
        
        // Then
        assertEquals(klient, expectedClient);
    }

    @Test
    @DisplayName("Should describe operation")
    void opisz() {
        // When
        String desc = operacjaWplaty.opisz();
        
        // Then
        assertEquals("Operacja wpłaty nr: 12345", desc);
    }
}