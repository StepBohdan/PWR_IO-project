package Model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
    void dajNrOperacji() {
        assertEquals("12345", operacjaWplaty.dajNrOperacji());
    }

    @Test
    void dajKlienta() {
        assertEquals(klient, operacjaWplaty.dajKlienta());
    }

    @Test
    void opisz() {
        assertEquals("Operacja wpłaty nr: 12345", operacjaWplaty.opisz());
    }
}