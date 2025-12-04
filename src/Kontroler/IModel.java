package Kontroler;

public interface IModel {

	/**
	 * 
	 * @param nrOperacji
	 */
	boolean anulowanieOperacji(int nrOperacji);

	/**
	 * 
	 * @param nrRachunku
	 */
	String pobieranieDanychKonta(int nrRachunku);

	/**
	 * 
	 * @param nrOperacji
	 */
	String pobieranieDanychOperacji(int nrOperacji);

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
	boolean wplacaniesrodkow(int nrRachunku, float kwota);

	/**
	 * 
	 * @param nrRachunku
	 * @param kwota
	 */
	boolean wyplacanieSrodkow(int nrRachunku, float kwota);

}