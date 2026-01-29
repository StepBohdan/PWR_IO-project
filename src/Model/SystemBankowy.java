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
        this.dao = dao;
        this.klienci = new Klient[] {
                new Klient(1, "test", "", "test", 0.0f),
                new Klient(2, "test2", "test2", "test2", 0.0f)
        };
        this.historiiOperacji = new HistoriaOperacji[0];
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
        if (kwota <= 0) return false;
        if (!dao.istniejeKonto(nrRachunku)) return false;
        
        dao.dodajSaldo(nrRachunku, kwota);
        return true;
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
        return new OperacjaWplaty(nrOperacji, klienci[0]);
    }
    
    public void anulujOperacje(String nrOperacji) {
        // TODO - implement SystemBankowy.anulujOperacje
        throw new UnsupportedOperationException();
    }

}