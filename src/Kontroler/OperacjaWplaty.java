package Kontroler;

import Model.IModel;

public class OperacjaWplaty extends IStrategiaOperacjiBankowej {

    public OperacjaWplaty(IModel model, int nrRachunku, Drukarka drukarka, DozownikBanknotow dozownik, Monitor monitor) {
        this.model = model;
        this.nrRachunku = nrRachunku;
        this.drukarka = drukarka;
        this.dozownik = dozownik;
        this.monitor = monitor;
    }

    @Override
    public void wykonaj() {
        System.out.println("[OperacjaWplaty] wykonaj() START nrRachunku=" + nrRachunku);

        String[] opcjeKwot = new String[] { "20", "50", "100", "200", "500" };
        System.out.println("[OperacjaWplaty] pytam o kwotę");
        String kwotaStr = monitor.wyswietlOpcje("Wybierz kwotę wpłaty:", opcjeKwot);
        System.out.println("[OperacjaWplaty] wybrano kwotaStr=" + kwotaStr);

        float kwota;
        try {
            kwota = Float.parseFloat(kwotaStr.replace(",", ".").trim());
        } catch (Exception e) {
            System.out.println("[OperacjaWplaty] BŁĄD parsowania kwoty -> STOP");
            monitor.wyswietl("Niepoprawna kwota: " + kwotaStr);
            return;
        }

        System.out.println("[OperacjaWplaty] zliczam banknoty...");
        float zliczonaKwota = dozownik.zliczBanknoty();
        System.out.println("[OperacjaWplaty] zliczonaKwota=" + zliczonaKwota + " oczekiwana=" + kwota);

        if (kwota != zliczonaKwota) {
            System.out.println("[OperacjaWplaty] NIEZGODNOŚĆ kwot -> zwrot banknotów i STOP");
            monitor.wyswietl("Błąd: wybrana kwota (" + kwota + ") != zliczona kwota (" + zliczonaKwota + ").");
            dozownik.zwrocBanknoty();
            return;
        }

        System.out.println("[OperacjaWplaty] wykonuję wpłatę w modelu...");
        boolean sukces = model.wplacanieSrodkow(nrRachunku, kwota);
        System.out.println("[OperacjaWplaty] model.wplacanieSrodkow -> sukces=" + sukces);

        if (!sukces) {
            System.out.println("[OperacjaWplaty] wpłata NIEUDANA -> STOP");
            monitor.wyswietl("Wpłata nie powiodła się.");
            return;
        }

        monitor.wyswietl("Wpłata zakończona sukcesem. Kwota: " + kwota);

        System.out.println("[OperacjaWplaty] pytam o wydruk...");
        String opcja = monitor.wyswietlOpcje("Czy wydrukować potwierdzenie?", new String[] { "Tak", "Nie" });
        System.out.println("[OperacjaWplaty] opcja wydruku=" + opcja);

        if (opcja.equalsIgnoreCase("tak")) {
            String nrOperacji = "NROP-" + System.currentTimeMillis();
            System.out.println("[OperacjaWplaty] tworzę OperacjaWydruku nrOperacji=" + nrOperacji);

            OperacjaWydruku wydruk = new OperacjaWydruku(model, drukarka, nrOperacji, monitor);
            wydruk.drukuj();
        }

        System.out.println("[OperacjaWplaty] wykonaj() END");
    }
}
