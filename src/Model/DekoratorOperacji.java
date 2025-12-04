package Model;

public abstract class DekoratorOperacji implements IOperacja {

	protected IOperacja operacja;
	protected int nrOperacji;

	public int dajNrOperacji() {
		// TODO - implement DekoratorOperacji.dajNrOperacji
		throw new UnsupportedOperationException();
	}

	public Klient dajKlienta() {
		// TODO - implement DekoratorOperacji.dajKlienta
		throw new UnsupportedOperationException();
	}

	public String opisz() {
		// TODO - implement DekoratorOperacji.opisz
		throw new UnsupportedOperationException();
	}

}