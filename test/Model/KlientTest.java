package Model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    @Tag("model")
    @DisplayName("Should return first name")
    void dajImie() {
        // When
        String name = klient.dajImie();
        
        // Then
        assertEquals("Jan", name);
    }

    @Test
    @Order(2)
    @Tag("model")
    @DisplayName("Should return second name")
    void dajDrugieImie() {
        // When
        String middleName = klient.dajDrugieImie();
        
        // Then
        assertEquals("Adam", middleName);
    }

    @Test
    @Order(3)
    @Tag("model")
    @DisplayName("Should return last name")
    void dajNazwisko() {
        // When
        String lastName = klient.dajNazwisko();
        
        // Then
        assertEquals("Kowalski", lastName);
    }

    @Test
    @Order(4)
    @Tag("model")
    @DisplayName("Should return account number")
    void dajNrRachunku() {
        // When
        int invoiceNumber  = klient.dajNrRachunku();
                
        // Then
        assertEquals(12345678, invoiceNumber);
    }

    @Test
    @Order(5)
    @Tag("model")
    @DisplayName("Should return balance")
    void dajSaldo() {
        // When
        float balance = klient.dajSaldo();
        
        // Then
        assertEquals(1000.0f, balance);
    }

    private static Stream<Arguments> provideClientsAndExpectedStrings() {
        return Stream.of(
                Arguments.of(klient, String.format("Klient: Jan Adam Kowalski%nNr rachunku: 12345678%nSaldo: 1000.00")),
                Arguments.of(klientBezDrugiegoImienia, String.format("Klient: Anna Nowak%nNr rachunku: 87654321%nSaldo: 2000.00"))
        );
    }

    @ParameterizedTest
    @Order(6)
    @Tag("model")
    @MethodSource("provideClientsAndExpectedStrings")
    @DisplayName("Should describe client")
    void opisz(Klient client, String expected) {
        // Then
        assertEquals(expected, client.opisz());
    }
}