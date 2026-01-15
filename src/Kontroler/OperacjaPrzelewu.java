package Kontroler;

import Model.*;

public class OperacjaPrzelewu implements IOperacja {

    private Klient klienci;

    /**
     *
     * @param nrOperacji
     * @param nadawca
     * @param odbiorca
     */
    public OperacjaPrzelewu(String nrOperacji, Klient nadawca, Klient odbiorca) {
        // TODO - implement OperacjaPrzelewu.OperacjaPrzelewu
        throw new UnsupportedOperationException();
    }

    public Klient dajObriorce() {
        // TODO - implement OperacjaPrzelewu.dajObriorce
        throw new UnsupportedOperationException();
    }

    @Override
    public String dajNrOperacji() {
        return "";
    }

    @Override
    public Klient dajKlienta() {
        return null;
    }

    public String opisz() {
        // TODO - implement OperacjaPrzelewu.opisz
        throw new UnsupportedOperationException();
    }

}