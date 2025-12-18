package Kontroler;

public class CzytnikKart {

    private boolean kartaWlozona;

    public CzytnikKart() {
        this.kartaWlozona = false;
    }

    public void wlozKarte() {
        this.kartaWlozona = true;
    }

    public void usunKarte() {
        // symulacja usunięcia karty z czytnika
        this.kartaWlozona = false;
    }

    // opcjonalnie do testów
    public boolean czyKartaWlozona() {
        return kartaWlozona;
    }
}
