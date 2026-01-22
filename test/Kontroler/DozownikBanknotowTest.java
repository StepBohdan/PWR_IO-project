package Kontroler;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DozownikBanknotowTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private DozownikBanknotow dozownikBanknotow;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        dozownikBanknotow = new DozownikBanknotow();
        outContent.reset();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @Order(1)
    @Tag("controller")
    @Tag("transaction")
    @DisplayName("Should count banknotes and return correct amount")
    void zliczBanknoty() {
        // Given
        float expectedAmount = 20.0f;

        // When
        float result = dozownikBanknotow.zliczBanknoty();

        // Then
        assertEquals(expectedAmount, result);
    }
}