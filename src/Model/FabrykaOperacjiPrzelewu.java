package Model;


public class FabrykaOperacjiPrzelewu implements IFabrykaOperacji {

    private IOperacja operacja;
    private Klient[] klienci;

    /**
     *
     * @param opis
     */
    public Model.IOperacja utworzOperacje(String opis) {
        // TODO - implement FabrykaOperacjiPrzelewu.utworzOperacje
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nadawca
     * @param odbiorca
     * @param operacja
     */
    public FabrykaOperacjiPrzelewu(Klient nadawca, Klient odbiorca, IOperacja operacja) {
        // TODO - implement FabrykaOperacjiPrzelewu.FabrykaOperacjiPrzelewu
        throw new UnsupportedOperationException();
    }

    @Override
    public Model.IOperacja utworzOperacje(String opis) {
        return null;
    }
}