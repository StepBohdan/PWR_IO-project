package Kontroler;

public class DozownikBanknotow {
    public DozownikBanknotow() {
        System.out.println("[DozownikBanknotow] init");
    }

    public void wydajBanknoty(float kwota) {
        System.out.println("[DozownikBanknotow] wydajBanknoty(kwota=" + kwota + ")");

    }

    public float zliczBanknoty() {
        System.out.println("[DozownikBanknotow] zliczBanknoty() -> " + 20.0f);
        // simulated return value
        return 20.0f;
    }

    public void zwrocBanknoty() {
        System.out.println("[DozownikBanknotow] zwrocBanknoty()");
    }
}
