package Kontroler;

public interface IKontrolerSystemuBankowego {

	/**
	 * @param nrOperacji
	 */
	void anulowanieOperacji(int nrOperacji);

	/**
	 * 
	 * @param nrOperacji
	 */
	void pobierzDaneOperacji(int nrOperacji);

	/**
	 * 
	 * @param nrRachunku
	 */
	void pobierzDaneKonta(int nrRachunku);

}