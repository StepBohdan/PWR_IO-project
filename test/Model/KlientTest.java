package Model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlientTest {

    private static Klient klient;
    private static Klient klientBezDrugiegoImienia;

    @BeforeAll
    static void setUp() {
        klient = new Klient(12345678, "Jan", "Adam", "Kowalski", 1000.0f);
        klientBezDrugiegoImienia = new Klient(87654321, "Anna", "", "Nowak", 2000.0f);
    }

    @AfterAll
    static void tearDown() {
        klient = null;
        klientBezDrugiegoImienia = null;
    }

    @Test
    void dajImie() {
        assertEquals("Jan", klient.dajImie());
    }

    @Test
    void dajDrugieImie() {
        assertEquals("Adam", klient.dajDrugieImie());
    }

    @Test
    void dajNazwisko() {
        assertEquals("Kowalski", klient.dajNazwisko());
    }

    @Test
    void dajNrRachunku() {
        assertEquals(12345678, klient.dajNrRachunku());
    }

    @Test
    void dajSaldo() {
        assertEquals(1000.0f, klient.dajSaldo());
    }

    @Test
    void opisz() {
        String expected = String.format("Klient: Jan Adam Kowalski%nNr rachunku: 12345678%nSaldo: 1000.00");
        assertEquals(expected, klient.opisz());

        String expectedBezDrugiegoImienia = String.format("Klient: Anna Nowak%nNr rachunku: 87654321%nSaldo: 2000.00");
        assertEquals(expectedBezDrugiegoImienia, klientBezDrugiegoImienia.opisz());
    }
}