package Kontroler;

public class CzytnikKart {

    private boolean kartaWlozona;

    public CzytnikKart() {
        this.kartaWlozona = false;
        System.out.println("[CzytnikKart] init");
    }

    public void usunKarte() {
        this.kartaWlozona = false;
        System.out.println("[CzytnikKart] usunKarte()");
    }
}
