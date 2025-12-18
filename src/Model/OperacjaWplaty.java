package Model;

import java.util.UUID;

public class OperacjaWplaty implements IOperacja {

    private final String nrOperacji = UUID.randomUUID().toString();
    private final Klient klient;
    private final String opis;

    public OperacjaWplaty(Klient klient, String opis) {
        if (klient == null) throw new IllegalArgumentException("Klient nie może być null");
        this.klient = klient;
        this.opis = (opis == null) ? "" : opis;
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
        return "WPŁATA: " + opis;
    }
}
