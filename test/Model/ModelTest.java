package Model;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ModelTest {

    @Mock
    private IDAO dao;

    @Mock
    private SystemBankowy systemBankowy;

    @InjectMocks
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    @Tag("model")
    void wplacanieSrodkow() {
        when(systemBankowy.wykonajWplate(1, 100.0f)).thenReturn(true);
        assertTrue(model.wplacanieSrodkow(1, 100.0f));
        verify(systemBankowy).wykonajWplate(1, 100.0f);

        assertFalse(model.wplacanieSrodkow(1, -50.0f));
        verify(systemBankowy, never()).wykonajWplate(1, -50.0f);
    }

    @Test
    @Order(2)
    @Tag("model")
    void wyplacanieSrodkow() {
        assertFalse(model.wyplacanieSrodkow(1, 100.0f));
        
        model.wplacanieSrodkow(1, 200.0f);
        assertTrue(model.wyplacanieSrodkow(1, 100.0f));
        assertEquals("Nr rachunku: 1\nSaldo: 100.0", model.pobieranieDanychKonta(1));
    }

    @Test
    @Order(3)
    @Tag("model")
    void pobieranieDanychKonta() {
        assertEquals("Nr rachunku: 1\nSaldo: 0.0", model.pobieranieDanychKonta(1));
        
        model.wplacanieSrodkow(1, 150.0f);
        model.wyplacanieSrodkow(1, 50.0f);
        assertEquals("Nr rachunku: 1\nSaldo: 100.0", model.pobieranieDanychKonta(1));
    }

    @Test
    @Order(4)
    @Tag("model")
    void pobieranieDanychOperacji() {
        String nrOperacji = "NROP-12345";
        assertEquals("Brak danych dla operacji: " + nrOperacji, model.pobieranieDanychOperacji(nrOperacji));
        
        model.wplacanieSrodkow(1, 100.0f);
        model.wyplacanieSrodkow(1, 50.0f);
    }

    @Test
    @Order(5)
    @Tag("model")
    void pobieranieHistorii() {
        assertArrayEquals(new String[0], model.pobieranieHistorii(1));
        
        model.wplacanieSrodkow(1, 200.0f);
        model.wyplacanieSrodkow(1, 100.0f);
        assertEquals(1, model.pobieranieHistorii(1).length);
    }

    @Test
    @Order(6)
    @Tag("model")
    void anulowanieOperacji() {
        String nrOperacji = "NROP-12345";
        assertFalse(model.anulowanieOperacji(nrOperacji));
        
        model.wplacanieSrodkow(1, 100.0f);
        model.wyplacanieSrodkow(1, 50.0f);
    }

    @Test
    @Order(7)
    @Tag("model")
    void przelew() {
        doNothing().when(systemBankowy).wykonajPrzelew(1, 2, 100.0f);
        model.przelew(1, 2, 100.0f);
        verify(systemBankowy, times(1)).wykonajPrzelew(1, 2, 100.0f);
    }
}