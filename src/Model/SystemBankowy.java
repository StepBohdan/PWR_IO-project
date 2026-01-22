package Model;


public class SystemBankowy {

    private IDAO dao;
    private Klient[] klienci;
    private HistoriaOperacji[] historiiOperacji;

    /**
     *
     * @param dao
     */
    public SystemBankowy(IDAO dao) {
        // TODO - implement SystemBankowy.SystemBankowy
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrKlienta
     */
    public Klient pobierzKlienta(int nrKlienta) {
        // TODO - implement SystemBankowy.pobierzKlienta
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrNadawcy
     * @param nrOdbiorcy
     * @param kwota
     */
    public void wykonajPrzelew(int nrNadawcy, int nrOdbiorcy, float kwota) {
        // TODO - implement SystemBankowy.wykonajPrzelew
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrRachunku
     * @param kwota
     */
    public boolean wykonajWplate(int nrRachunku, float kwota) {
        // TODO - implement SystemBankowy.wykojWplate
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrRachunku
     * @param kwota
     */
    public boolean wykonajWyplate(int nrRachunku, float kwota) {
        // TODO - implement SystemBankowy.wykonajWyplate
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrRachunku
     */
    public HistoriaOperacji pobierzHistorieOperacji(int nrRachunku) {
        // TODO - implement SystemBankowy.pobierzHistorieOperacji
        throw new UnsupportedOperationException();
    }
    
    public IOperacja pobierzDaneOperacji(String nrOperacji) {
        // TODO - implement SystemBankowy.pobierzDaneOperacji
        throw new UnsupportedOperationException();
    }
    
    public void anulujOperacje(String nrOperacji) {
        // TODO - implement SystemBankowy.anulujOperacje
        throw new UnsupportedOperationException();
    }

}