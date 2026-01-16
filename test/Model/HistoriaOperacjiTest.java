package Model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HistoriaOperacjiTest {

    private HistoriaOperacji historiaOperacji;
    private final IOperacja operacja1 = new OperacjaWplaty("1", null);
    private final IOperacja operacja2 = new OperacjaWplaty("2", null);

    @BeforeEach
    void setUp() {
        historiaOperacji = new HistoriaOperacji();
    }

    @Test
    @Order(1)
    @DisplayName("Should add operation")
    void dodajOperacje() {
        // When
        boolean success = historiaOperacji.dodajOperacje(operacja1);
        boolean fail = historiaOperacji.dodajOperacje(null);
        
        // Then
        assertTrue(success);
        assertFalse(fail);
    }

    @Order(3)
    @DisplayName("Should remove operation")
    @ParameterizedTest
    @CsvSource({
            "1, true",
            "3, false"
    })
    void usunOperacje(String nrOperacjiDoUsuniecia, boolean expectedResult) {
        // Given
        historiaOperacji.dodajOperacje(operacja1);
        historiaOperacji.dodajOperacje(operacja2);
        
        // When
        assertEquals(expectedResult, historiaOperacji.usunOperacje(nrOperacjiDoUsuniecia));
        
        // Then
        if (expectedResult) {
            assertEquals(1, historiaOperacji.dajHistorieOperacji().length);
        } else {
            assertEquals(2, historiaOperacji.dajHistorieOperacji().length);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Should return operations history")
    void dajHistorieOperacji() {
        // Given
        historiaOperacji.dodajOperacje(operacja1);
        historiaOperacji.dodajOperacje(operacja2);
        
        // When
        IOperacja[] historia = historiaOperacji.dajHistorieOperacji();
        
        // Then
        assertEquals(2, historia.length);
        assertEquals(operacja1, historia[0]);
        assertEquals(operacja2, historia[1]);
    }

    @Test
    @Order(4)
    @DisplayName("Should describe operations")
    void opisz() {
        // Given
        historiaOperacji.dodajOperacje(operacja1);
        historiaOperacji.dodajOperacje(operacja2);
        
        // When
        String[] opisy = historiaOperacji.opisz();
        
        // Then
        assertEquals(2, opisy.length);
        assertEquals(operacja1.opisz(), opisy[0]);
        assertEquals(operacja2.opisz(), opisy[1]);
    }
}