package Model;

public interface IDAO {

	/**
	 * 
	 * @param klient
	 */
	void dodajKlienta(String klient);

	/**
	 * 
	 * @param operacja
	 */
	void dodajOperacje(String operacja);

	/**
	 * 
	 * @param klient
	 */
	void edytujKlienta(String klient);

	/**
	 * 
	 * @param nrKlienta
	 * @param iloscOperacji
	 */
    String[] pobierzHistorieOperacjiKlienta(int nrKlienta, int iloscOperacji);

	/**
	 * 
	 * @param nrKlienta
	 */
    String pobierzKlienta(int nrKlienta);

	/**
	 * 
	 * @param nrKlienta
	 */
	void usunKlienta(int nrKlienta);

	/**
	 * 
	 * @param nrOperacji
	 */
	void usunOperacja(int nrOperacji);

}