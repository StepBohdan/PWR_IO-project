package Kontroler;

public class Monitor {
    private float kwota;

    public Monitor() {
        System.out.println("[Monitor] init");
    }

    public void wyswietl(String komunikat) {
        System.out.println("[Monitor] " + komunikat);
    }
    
    public void ustawKwote(float kwota) {
        this.kwota = kwota;
    }

    public String wyswietlOpcje(String komunikat, String[] opcje) {
        System.out.println("[Monitor] " + komunikat);
        
        return Float.toString(kwota);

//        if (opcje == null || opcje.length == 0) {
//            System.out.println("[Monitor] (brak opcji)");
//            return "";
//        }
//
//        System.out.print("[Monitor] opcje: ");
//        for (int i = 0; i < opcje.length; i++) {
//            System.out.print(opcje[i]);
//            if (i < opcje.length - 1) System.out.print(", ");
//        }
//        System.out.println();
//
//        // symulacja: wybieramy pierwszą opcję
//        String wybor = opcje[0];
//        System.out.println("[Monitor] wybrano: " + wybor);
//        return wybor;
    }
}
