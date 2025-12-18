package Model;

import java.util.UUID;

public class OperacjaPrzelewu implements IOperacja {

    private final String nrOperacji;
    private final Klient nadawca;
    private final Klient odbiorca;
    private final String opis;

    public OperacjaPrzelewu(Klient nadawca, Klient odbiorca, String opis) {
        if (nadawca == null || odbiorca == null) {
            throw new IllegalArgumentException("Nadawca i odbiorca nie mogą być null");
        }
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.opis = (opis == null) ? "" : opis;
        this.nrOperacji = UUID.randomUUID().toString();
    }

    @Override
    public String dajNrOperacji() {
        return nrOperacji;
    }

    @Override
    public Klient dajKlienta() {
        // Обычно "клиент операции" — инициатор (nadawca)
        return nadawca;
    }

    public Klient dajOdbiorce() {
        return odbiorca;
    }

    @Override
    public String opisz() {
        return "PRZELEW: " + opis;
    }
}
