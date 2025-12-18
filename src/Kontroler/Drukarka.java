package Kontroler;

public class Drukarka {

    public Drukarka() {
        System.out.println("[Drukarka] init");
    }

    public void drukuj(String dane) {
        System.out.println("[Drukarka] DRUKUJĘ:");
        System.out.println(dane == null ? "" : dane);
        System.out.println("[Drukarka] --- KONIEC WYDRUKU ---");
    }
}
