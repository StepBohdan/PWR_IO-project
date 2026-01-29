package TestyFitnesse;

import Kontroler.OperacjaWplaty;
import fit.ColumnFixture;

public class WplataGotowkiTest extends ColumnFixture {
    int nrRachunku;
    float kwota;
    
    /*
     * Operacja testującą realizację PU01
     * @return true, jeśli saldo klienta powiększyło się o podaną kwotę
     * po wykonaniu operacji testowanej
     * (Klient musi istnieć)
     */
    public boolean wplataGotowki() {
        float stanPrzed = dajSaldoKlienta();

        SetUp.ustawKwote(kwota);

        OperacjaWplaty pu02 = new OperacjaWplaty(SetUp.model, nrRachunku, SetUp.drukarka, SetUp.dozownik, SetUp.monitor);
        pu02.wykonaj();
        
        float stanPo = dajSaldoKlienta();
        
        return stanPo == stanPrzed + kwota;
    };
    
    public float dajSaldoKlienta() {
        return SetUp.dao.pobierzSaldo(nrRachunku);
    }
}
