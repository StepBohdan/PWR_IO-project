package Model;

public class Model implements IModel {

	public IDAO dao;

	/**
	 * 
	 * @param nrOperacji
	 */
	public boolean anulowanieOperacji(int nrOperacji) {
		// TODO - implement Model.anulowanieOperacji
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrRachunku
	 */
	public String pobieranieDanychKonta(int nrRachunku) {
		// TODO - implement Model.pobieranieDanychKonta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrOperacji
	 */
	public String pobieranieDanychOperacji(int nrOperacji) {
		// TODO - implement Model.pobieranieDanychOperacji
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrRachunku
	 */
	public String[] pobieranieHistorii(int nrRachunku) {
		// TODO - implement Model.pobieranieHistorii
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrRachunku
	 * @param kwota
	 */
	public boolean wplacanieSrodkow(int nrRachunku, float kwota) {
		// TODO - implement Model.wp?acanie?rodk�w
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nrRachunku
	 * @param kwota
	 */
	public boolean wyplacanieSrodkow(int nrRachunku, float kwota) {
		// TODO - implement Model.wyp?acanie?rodk�w
		throw new UnsupportedOperationException();
	}

}