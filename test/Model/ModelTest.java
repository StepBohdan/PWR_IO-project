package Model;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ModelTest {

    private static final int Account1 = 1;
    private static final int Account2 = 2;
    
    @Mock
    private SystemBankowy systemBankowy;

    @InjectMocks
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Klient klient = mock(Klient.class);
        when(klient.dajSaldo()).thenReturn(0f);
        when(systemBankowy.pobierzKlienta(anyInt())).thenReturn(klient);
    }

    @Test
    @Order(2)
    @DisplayName("should be able to deposit")
    @Tag("model")
    void wplacanieSrodkow() {
        // Given
        when(systemBankowy.wykonajWplate(Account1, 100.0f)).thenReturn(true);
        
        // When
        boolean result = model.wplacanieSrodkow(Account1, 100.0f);
        
        // Then
        assertTrue(result);
        assertEquals("Nr rachunku: 1\nSaldo: 100.0", model.pobieranieDanychKonta(Account1));
        verify(systemBankowy).wykonajWplate(Account1, 100.0f);
    }

    @Test
    @Order(3)
    @Tag("model")
    @DisplayName("should not be able to deposit negative amount")
    void wplacanieSrodkowUjemne() {
        // Given
        // (initial setup in setUp method)
        
        // When
        boolean result1 = model.wplacanieSrodkow(Account1, 0.0f);
        boolean result2 = model.wplacanieSrodkow(Account1, -50.0f);
        
        // Then
        assertFalse(result1);
        assertFalse(result2);
        assertEquals("Nr rachunku: 1\nSaldo: 0.0", model.pobieranieDanychKonta(Account1));

        verify(systemBankowy, never()).wykonajWplate(Account1, 0.0f);
        verify(systemBankowy, never()).wykonajWplate(Account1, -50.0f);
    }

    @Test
    @Order(4)
    @Tag("model")
    @DisplayName("should be able to withdraw")
    void wyplacanieSrodkow() {
        // Given
        when(systemBankowy.wykonajWyplate(Account1, 100.0f)).thenReturn(true);
        model.wplacanieSrodkow(Account1, 200.0f);
        
        // When
        boolean result = model.wyplacanieSrodkow(Account1, 100.0f);
        
        // Then
        assertTrue(result);
        assertEquals("Nr rachunku: 1\nSaldo: 100.0", model.pobieranieDanychKonta(Account1));
        verify(systemBankowy).wykonajWyplate(Account1, 100.0f);
    }
    
    @Test
    @Order(5)
    @Tag("model")
    @DisplayName("should not be able to withdraw negative amount")
    void wyplacanieSrodkowUjemne() {
        // Given
        // (initial setup in setUp method)
        
        // When
        boolean result = model.wyplacanieSrodkow(Account1, -100.0f);
        
        // Then
        assertFalse(result);
        assertEquals("Nr rachunku: 1\nSaldo: 0.0", model.pobieranieDanychKonta(Account1));
        verify(systemBankowy, never()).wykonajWyplate(1, -100.0f);
    }

    @Test
    @Order(1)
    @Tag("model")
    @DisplayName("should be able to get account balance")
    void pobieranieDanychKonta() {
        // Given
        // (initial setup in setUp method)
        
        // When
        String result = model.pobieranieDanychKonta(Account1);
        
        // Then
        assertEquals("Nr rachunku: 1\nSaldo: 0.0", result);
        verify(systemBankowy).pobierzKlienta(Account1);
    }

    @Test
    @Order(6)
    @Tag("model")
    @DisplayName("should be able to get operation info")
    void pobieranieDanychOperacji() {
        // Given
        String nrOperacji = "NROP-12345";
        Klient klient = new Klient(Account1, "test", "", "test", 0f);
        IOperacja operacja = new OperacjaWplaty(nrOperacji, klient);
        when(systemBankowy.pobierzDaneOperacji(nrOperacji)).thenReturn(operacja);
        
        // When
        model.pobieranieDanychOperacji(nrOperacji);
        
        // Then
        verify(systemBankowy).pobierzDaneOperacji(nrOperacji);
    }

    @Test
    @Order(7)
    @Tag("model")
    @DisplayName("should be able to get transaction history")
    void pobieranieHistorii() {
        // Given
        HistoriaOperacji historiaOperacji = new HistoriaOperacji();
        when(systemBankowy.pobierzHistorieOperacji(Account1)).thenReturn(historiaOperacji);
        
        // When
        model.pobieranieHistorii(Account1);
        
        // Then
        verify(systemBankowy).pobierzHistorieOperacji(Account1);
    }

    @Test
    @Order(8)
    @Tag("model")
    @DisplayName("should be able to cancel operation")
    void anulowanieOperacji() {
        // Given
        String nrOperacji = "NROP-12345";
        doNothing().when(systemBankowy).anulujOperacje(nrOperacji);
        
        // When
        model.anulowanieOperacji(nrOperacji);
        
        // Then
        verify(systemBankowy).anulujOperacje(nrOperacji);
    }

    @Test
    @Order(9)
    @Tag("model")
    @DisplayName("should be able to transfer money to another account")
    void przelew() {
        // Given
        doNothing().when(systemBankowy).wykonajPrzelew(Account1, Account2, 100.0f);
        
        // When
        model.przelew(Account1, Account2, 100.0f);
        
        // Then
        verify(systemBankowy, times(1)).wykonajPrzelew(Account1, Account2, 100.0f);
    }
}