package Model;

public class FabrykaOperacjiPrzelewu implements IFabrykaOperacji {

    private final Klient nadawca;
    private final Klient odbiorca;

    public FabrykaOperacjiPrzelewu(Klient nadawca, Klient odbiorca) {
        if (nadawca == null || odbiorca == null) {
            throw new IllegalArgumentException("Nadawca i odbiorca nie mogą być null");
        }
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
    }

    @Override
    public IOperacja utworzOperacje(String opis) {
        return new OperacjaPrzelewu(nadawca, odbiorca, opis);
    }
}
