package Kontroler;

import Model.IModel;

public class OperacjaWplaty extends IStrategiaOperacjiBankowej {

    public OperacjaWplaty(IModel model, int nrRachunku, Drukarka drukarka, DozownikBanknotow dozownik, Monitor monitor) {
        if (model == null || drukarka == null || dozownik == null || monitor == null) {
            throw new IllegalArgumentException("model/drukarka/dozownik/monitor nie mogą być null");
        }
        this.model = model;
        this.nrRachunku = nrRachunku;
        this.drukarka = drukarka;
        this.dozownik = dozownik;
        this.monitor = monitor;
    }

    @Override
    public void wykonaj() {
        String[] opcjeKwot = new String[] { "20", "50", "100", "200", "500" };
        String kwotaStr = monitor.wyswietlOpcje("Wybierz kwotę wpłaty:", opcjeKwot);

        float kwota;
        try {
            kwota = Float.parseFloat(kwotaStr.replace(",", ".").trim());
        } catch (Exception e) {
            monitor.wyswietl("Niepoprawna kwota: " + kwotaStr);
            return;
        }

        float zliczonaKwota = dozownik.zliczBanknoty();

        if (Float.compare(kwota, zliczonaKwota) != 0) {
            monitor.wyswietl("Błąd: wybrana kwota (" + kwota + ") != zliczona kwota (" + zliczonaKwota + ").");
            dozownik.zwrocBanknoty();
            return;
        }

        boolean sukces = model.wplacanieSrodkow(nrRachunku, kwota);

        if (sukces) {
            monitor.wyswietl("Wpłata zakończona sukcesem. Kwota: " + kwota);
        } else {
            monitor.wyswietl("Wpłata nie powiodła się.");
            return;
        }

        String opcja = monitor.wyswietlOpcje("Czy wydrukować potwierdzenie?", new String[] { "Tak", "Nie" });

        if ("Tak".equalsIgnoreCase(opcja)) {
            String nrOperacji = "WPL-" + System.currentTimeMillis();
            OperacjaWydruku wydruk = new OperacjaWydruku(model, drukarka, nrOperacji, this, monitor);
            wydruk.drukuj();
        }
    }
}
