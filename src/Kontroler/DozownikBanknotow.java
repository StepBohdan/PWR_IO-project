package Kontroler;

public class DozownikBanknotow {
    private float kwota;
    
    public DozownikBanknotow() {
        System.out.println("[DozownikBanknotow] init");
    }

    public void wydajBanknoty(float kwota) {
        System.out.println("[DozownikBanknotow] wydajBanknoty(kwota=" + kwota + ")");
    }
    
    public void ustawKwote(float kwota) {
        this.kwota = kwota;
    }

    public float zliczBanknoty() {
        System.out.println("[DozownikBanknotow] zliczBanknoty() -> " + kwota);
        return kwota;
    }

    public void zwrocBanknoty() {
        System.out.println("[DozownikBanknotow] zwrocBanknoty()");
    }
}
