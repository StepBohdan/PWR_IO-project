package Kontroler;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MonitorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @Order(1)
    @DisplayName("Should display message")
    void wyswietl() {
        // Given
        Monitor monitor = new Monitor();
        String message = "Test message";
        
        // When
        monitor.wyswietl(message);

        // Then
        assertTrue(outContent.toString().contains(message));
    }

    @ParameterizedTest
    @MethodSource("provideOpcjeForTest")
    @Order(2)
    @DisplayName("Should handle different options scenarios")
    void wyswietlOpcje(String[] opcje, String expectedResult, String expectedOutput) {
        // Given
        Monitor monitor = new Monitor();

        // When
        String result = monitor.wyswietlOpcje("Wybierz opcje:", opcje);
        
        // Then
        assertTrue(outContent.toString().contains(expectedOutput));
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> provideOpcjeForTest() {
        return Stream.of(
                Arguments.of(new String[]{"Opcja 1", "Opcja 2"}, "Opcja 1", "[Monitor] opcje: Opcja 1, Opcja 2"),
                Arguments.of(null, "", "[Monitor] (brak opcji)"),
                Arguments.of(new String[]{}, "", "[Monitor] (brak opcji)")
        );
    }
}