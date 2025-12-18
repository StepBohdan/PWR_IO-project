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
        if (model == null || monitor == null || czytnik == null) {
            throw new IllegalArgumentException("model/monitor/czytnik nie mogą być null");
        }
        this.model = model;
        this.monitor = monitor;
        this.czytnik = czytnik;
    }

    /**
     * @param nrOperacji
     */
    public void anuluj(String nrOperacji) {
        boolean sukces = model.anulowanieOperacji(nrOperacji);

        // alt:
        if (!sukces) {
            monitor.wyswietl("Nie udało się anulować operacji: " + nrOperacji);
        }
        czytnik.usunKarte();
    }
}
