package Model;

public interface IModel {

	/**
	 * 
	 * @param nrRachunku
	 */
	String pobieranieDanychKonta(int nrRachunku);

	/**
	 * 
	 * @param nrRachunku
	 */
    String[] pobieranieHistorii(int nrRachunku);

	/**
	 * 
	 * @param nrRachunku
	 * @param kwota
	 */
	boolean wyplacanieSrodkow(int nrRachunku, float kwota);

	/**
	 * 
	 * @param nrRachunku
	 * @param kwota
	 */
	boolean wplacanieSrodkow(int nrRachunku, float kwota);

	/**
	 * 
	 * @param nrOperacji
	 */
	String pobieranieDanychOperacji(int nrOperacji);

	/**
	 * 
	 * @param nrOperacji
	 */
	boolean anulowanieOperacji(int nrOperacji);

}