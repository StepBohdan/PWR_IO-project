package Model;

public class FabrykaOperacjiWplaty implements IFabrykaOperacji {

	private Klient klient;
	private IOperacja operacja;

	/**
	 * 
	 * @param klient
	 * @param operacja
	 */
	public FabrykaOperacjiWplaty(Klient klient, DekoratorOperacji operacja) {
		// TODO - implement FabrykaOperacjiWplaty.FabrykaOperacjiWplaty
		throw new UnsupportedOperationException();
	}

    /**
     *
     * @param opis
     */
    public IOperacja utworzOperacje(String opis) {
        // TODO - implement FabrykaOperacjiWyplaty.utworzOperacje
        throw new UnsupportedOperationException();
    }
}