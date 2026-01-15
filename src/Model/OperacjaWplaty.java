package Model;

public class OperacjaWplaty implements IOperacja {

    private final String nrOperacji;
    private final Klient klient;

    public OperacjaWplaty(String nrOperacji, Klient klient) {
        this.nrOperacji = nrOperacji;
        this.klient = klient;
    }

    @Override
    public String dajNrOperacji() {
        return nrOperacji;
    }

    @Override
    public Klient dajKlienta() {
        return klient;
    }

    @Override
    public String opisz() {
        return "Operacja wpłaty nr: " + nrOperacji;
    }
}
