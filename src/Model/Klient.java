package Model;
public class Klient {
	
	private String imie;
	private String drugieImie;
	private String nazwisko;
	private int nrRachunku;
	private float saldo;

	/**
	 * 
	 * @param nrRachunku
	 * @param imie
	 * @param nazwisko
	 * @param saldo
	 */
	public Klient(int nrRachunku, String imie, String drugieImie, String nazwisko, float saldo) {
		this.nrRachunku = nrRachunku;
		this.imie = imie;
		this.drugieImie = drugieImie;
		this.nazwisko = nazwisko;
		this.saldo = saldo;
	}
	
	public String dajImie() {
		return this.imie;
	}
	
	public String dajDrugieImie() {
		return this.drugieImie;
	}
	
	public String dajNazwisko() {
		return this.nazwisko;
	}
	
	public int dajNrRachunku() {
		return this.nrRachunku;
	}
	
	public float dajSaldo() {
		return this.saldo;
	}

	public String opisz() {
		String fullName = imie + (drugieImie != null && !drugieImie.trim().isEmpty() ? " " + drugieImie : "") + " " + nazwisko;
		return String.format("Klient: %s%nNr rachunku: %d%nSaldo: %.2f", fullName, nrRachunku, saldo);
	}

}