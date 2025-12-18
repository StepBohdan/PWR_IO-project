package Kontroler;

public class DozownikBanknotow {


    private float symulowanaKwotaWczytana = 20.0f;

    public DozownikBanknotow() {
        System.out.println("[DozownikBanknotow] init");
    }

    public void wydajBanknoty(float kwota) {
        System.out.println("[DozownikBanknotow] wydajBanknoty(kwota=" + kwota + ")");

    }

    public float zliczBanknoty() {
        System.out.println("[DozownikBanknotow] zliczBanknoty() -> " + symulowanaKwotaWczytana);
        return symulowanaKwotaWczytana;
    }

    public void zwrocBanknoty() {
        System.out.println("[DozownikBanknotow] zwrocBanknoty()");
    }


    public void ustawSymulowanaKwote(float kwota) {
        this.symulowanaKwotaWczytana = kwota;
    }
}
