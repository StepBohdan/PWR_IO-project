package Model;

<<<<<<< HEAD
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
=======
import Model.Klient;
import org.junit.jupiter.api.*;
>>>>>>> b89dd54 (zestawy testów)
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    @DisplayName("Should return first name")
<<<<<<< HEAD
=======
    @Tag("entity")
    @Tag("fast")
>>>>>>> b89dd54 (zestawy testów)
    void dajImie() {
        // When
        String name = klient.dajImie();
        
        // Then
        assertEquals("Jan", name);
    }

    @Test
    @DisplayName("Should return second name")
<<<<<<< HEAD
=======
    @Tag("entity")
    @Tag("fast")
>>>>>>> b89dd54 (zestawy testów)
    void dajDrugieImie() {
        // When
        String middleName = klient.dajDrugieImie();
        
        // Then
        assertEquals("Adam", middleName);
    }

    @Test
    @DisplayName("Should return last name")
<<<<<<< HEAD
=======
    @Tag("entity")
    @Tag("fast")
>>>>>>> b89dd54 (zestawy testów)
    void dajNazwisko() {
        // When
        String lastName = klient.dajNazwisko();
        
        // Then
        assertEquals("Kowalski", lastName);
    }

    @Test
    @DisplayName("Should return account number")
<<<<<<< HEAD
=======
    @Tag("entity")
    @Tag("fast")

>>>>>>> b89dd54 (zestawy testów)
    void dajNrRachunku() {
        // When
        int invoiceNumber  = klient.dajNrRachunku();
                
        // Then
        assertEquals(12345678, invoiceNumber);
    }

    @Test
    @DisplayName("Should return balance")
<<<<<<< HEAD
=======
    @Tag("entity")
    @Tag("fast")
>>>>>>> b89dd54 (zestawy testów)
    void dajSaldo() {
        // When
        float balance = klient.dajSaldo();
        
        // Then
        assertEquals(1000.0f, balance);
    }

    private static Stream<Arguments> provideClientsAndExpectedStrings() {
        return Stream.of(
<<<<<<< HEAD
                Arguments.of(klient, String.format("Klient: Jan Adam Kowalski%nNr rachunku: 12345678%nSaldo: 1000.00")),
                Arguments.of(klientBezDrugiegoImienia, String.format("Klient: Anna Nowak%nNr rachunku: 87654321%nSaldo: 2000.00"))
=======
                Arguments.of(klient, String.format("Klient: Jan Adam Kowalski%nNr rachunku: 12345678%nSaldo: 1000,00")),
                Arguments.of(klientBezDrugiegoImienia, String.format("Klient: Anna Nowak%nNr rachunku: 87654321%nSaldo: 2000,00"))
>>>>>>> b89dd54 (zestawy testów)
        );
    }

    @ParameterizedTest
    @MethodSource("provideClientsAndExpectedStrings")
    @DisplayName("Should describe client")
<<<<<<< HEAD
=======
    @Tag("entity")
    @Tag("format")
>>>>>>> b89dd54 (zestawy testów)
    void opisz(Klient client, String expected) {
        // Then
        assertEquals(expected, client.opisz());
    }
}