package Model;

public class FabrykaOperacjiWplaty implements IFabrykaOperacji {

    private final Klient klient;

    public FabrykaOperacjiWplaty(Klient klient) {
        if (klient == null) throw new IllegalArgumentException("Klient nie może być null");
        this.klient = klient;
    }

    @Override
    public IOperacja utworzOperacje(String opis) {
        return new OperacjaWplaty("1", klient);
    }
}
