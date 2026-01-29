package TestyFitnesse;

import Kontroler.AnulowanieOperacji;
import fit.ColumnFixture;

public class AnulowanieOperacjiTest extends ColumnFixture {
    String nrOperacji;
    
    private boolean stanPrzed;
    private boolean stanPo;
    
    

    /*
     * Operacja testującą realizację PU07
     * @return true, operacja została zanulowana
     * po wykonaniu operacji testowanej
     * (Klient musi istnieć)
     */
    public boolean anulowanieOperacji() {
        stanPrzed = SetUp.dao.pobierzOperacje(nrOperacji);
        
        AnulowanieOperacji pu07 = new AnulowanieOperacji(SetUp.model, SetUp.monitor, SetUp.czytnikKart);
        pu07.anuluj(nrOperacji);
        
        stanPo = SetUp.dao.pobierzOperacje(nrOperacji);
        
        return stanPrzed && !stanPo;
    }

    public boolean operacjaIstniala() {
        return stanPrzed;
    }

    public boolean operacjaIstnieje() {
        return stanPo;
    }
}
