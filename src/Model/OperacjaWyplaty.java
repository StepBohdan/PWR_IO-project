package Model;

import Model.*;

public class OperacjaWyplaty implements IOperacja {

    private String nrOperacji;
    private Klient klient;

    /**
     *
     * @param nrOperacji
     * @param klient
     */
    public OperacjaWyplaty(String nrOperacji, Klient klient) {
        this.nrOperacji = nrOperacji;
        this.klient = klient;
    }

    @Override
    public String dajNrOperacji() {
        return this.nrOperacji;
    }

    @Override
    public Klient dajKlienta() {
        return this.klient;
    }

    @Override
    public String opisz() {
        return "Operacja wypłaty nr: " + nrOperacji;
    }

}