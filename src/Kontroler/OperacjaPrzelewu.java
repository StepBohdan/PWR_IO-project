package Kontroler;


public class OperacjaPrzelewu extends IStrategiaOperacjiBankowej {

	private int nrRachunkuOdbiorcy;
	private float kwota;

	public void wykonaj() {
		// TODO - implement OperacjaPrzelewu.wykonaj
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param drukarka
	 */
	public void wykonaj(Drukarka drukarka) {

	}

	/**
	 * 
	 * @param model
	 * @param nrRachunkuNadawcy
	 * @param nrRachunkuOdbiorcy
	 * @param kwota
	 * @param drukarka
	 * @param dozownik
	 * @param monitor
	 */
	public OperacjaPrzelewu(IModel model, int nrRachunkuNadawcy, int nrRachunkuOdbiorcy, float kwota, Drukarka drukarka, DozownikBanknotow dozownik, Monitor monitor) {

	}

}