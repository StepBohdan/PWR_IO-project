package Model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    @Tag("model")
    void dajNrOperacji() {
        // When
        String operationId = operacjaWplaty.dajNrOperacji();
        
        // Then
        assertEquals("12345", operationId);
    }

    @Test
    @DisplayName("Should return client")
    @Order(2)
    @Tag("model")
    void dajKlienta() {
        // When
        Klient expectedClient = operacjaWplaty.dajKlienta();
        
        // Then
        assertEquals(klient, expectedClient);
    }

    @Test
    @DisplayName("Should describe operation")
    @Order(3)
    @Tag("model")
    void opisz() {
        // When
        String desc = operacjaWplaty.opisz();
        
        // Then
        assertEquals("Operacja wpłaty nr: 12345", desc);
    }
}