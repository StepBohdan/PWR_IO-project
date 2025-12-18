package Kontroler;

public class Monitor {

    public Monitor() {
        System.out.println("[Monitor] init");
    }

    public void wyswietl(String komunikat) {
        System.out.println("[Monitor] " + komunikat);
    }

    public String wyswietlOpcje(String komunikat, String[] opcje) {
        System.out.println("[Monitor] " + komunikat);

        if (opcje == null || opcje.length == 0) {
            System.out.println("[Monitor] (brak opcji)");
            return "";
        }

        System.out.print("[Monitor] opcje: ");
        for (int i = 0; i < opcje.length; i++) {
            System.out.print(opcje[i]);
            if (i < opcje.length - 1) System.out.print(", ");
        }
        System.out.println();

        // symulacja: wybieramy pierwszą opcję
        String wybor = opcje[0];
        System.out.println("[Monitor] wybrano: " + wybor);
        return wybor;
    }
}
