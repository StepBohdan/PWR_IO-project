package Kontroler;

import Model.IModel;

public class AnulowanieOperacji {

    private final IModel model;
    private final Monitor monitor;
    private final CzytnikKart czytnik;

    /**
     * @param model
     * @param monitor
     * @param czytnik
     */
    public AnulowanieOperacji(IModel model, Monitor monitor, CzytnikKart czytnik) {
        this.model = model;
        this.monitor = monitor;
        this.czytnik = czytnik;
    }

    /**
     * @param nrOperacji
     */
    public void anuluj(String nrOperacji) {
        System.out.println("[AnulowanieOperacji] anuluj() START nrOperacji=" + nrOperacji);

        boolean sukces = model.anulowanieOperacji(nrOperacji);
        System.out.println("[AnulowanieOperacji] model.anulowanieOperacji -> sukces=" + sukces);

        if (sukces) {
            System.out.println("[AnulowanieOperacji] anulowanie POWIODŁO SIĘ -> komunikat na monitor");
            monitor.wyswietl("Operacja została anulowana.");
        } else {
            System.out.println("[AnulowanieOperacji] anulowanie NIEUDANE -> komunikat na monitor");
            monitor.wyswietl("Nie udało się anulować operacji: " + nrOperacji);
        }

        System.out.println("[AnulowanieOperacji] usuńKarte()");
        czytnik.usunKarte();

        System.out.println("[AnulowanieOperacji] anuluj() END");
    }
}
