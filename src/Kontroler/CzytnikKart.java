package Kontroler;

public class CzytnikKart {

    private boolean kartaWlozona;

    public CzytnikKart() {
        this.kartaWlozona = false;
        System.out.println("[CzytnikKart] init");
    }

    public void wlozKarte() {
        this.kartaWlozona = true;
        System.out.println("[CzytnikKart] wlozKarte()");
    }

    public void usunKarte() {
        this.kartaWlozona = false;
        System.out.println("[CzytnikKart] usunKarte()");
    }

    public boolean czyKartaWlozona() {
        return kartaWlozona;
    }
}
