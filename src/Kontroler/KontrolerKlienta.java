package Kontroler;
import java.util.UUID;
import Model.IModel;

public class KontrolerKlienta {
    private IModel model;
    private int nrRachunku;
    private Drukarka drukarka;
    private DozownikBanknotow dozownik;
    private Monitor monitor;
    private CzytnikKart czytnik;
    private UUID nrOperacji;
    private IStrategiaOperacjiBankowej strategiaOperacjiBankowej;

    public KontrolerKlienta(IModel model) {
        if (model == null) {
            throw new IllegalArgumentException("model nie może być null");
        }
        this.model = model;

        this.monitor = new Monitor();
        this.drukarka = new Drukarka();
        this.dozownik = new DozownikBanknotow();
        this.czytnik = new CzytnikKart();
        this.nrRachunku = 0;
        this.nrOperacji = null;
        this.strategiaOperacjiBankowej = null;
    }

    public void wyplataGotowki() {
        // TODO - implement KontrolerKlienta.wyp?ataGot?wki
        throw new UnsupportedOperationException();
    }

    public void wplataGotowki() {
        // 1.1: OperacjaWplaty(...)
        strategiaOperacjiBankowej = new OperacjaWplaty(model, nrRachunku, drukarka, dozownik, monitor);

        // 1.2: wykonaj()
        strategiaOperacjiBankowej.wykonaj();
    }

    public void przelew() {
        // TODO - implement KontrolerKlienta.przelew
        throw new UnsupportedOperationException();
    }

    public void wyborJezykuInterfejsu() {
        // TODO - implement KontrolerKlienta.wyb?rJ?zykuInterfejsu
        throw new UnsupportedOperationException();
    }

    public void wyswietlenieSalda() {
        // TODO - implement KontrolerKlienta.wy?wietlenieSalda
        throw new UnsupportedOperationException();
    }

    public void wyswietlenieHistoriiOperacji() {
        // TODO - implement KontrolerKlienta.wy?wietlenieHistoriiOperacji
        throw new UnsupportedOperationException();
    }

    public void anulowanieOperacji() {
        // 1.1: AnulowanieOperacji(model, monitor, czytnik)
        AnulowanieOperacji anulowanie = new AnulowanieOperacji(model, monitor, czytnik);

        // 1.2: anuluj(nrOperacji:String)
        if (nrOperacji == null) {
            monitor.wyswietl("Brak numeru operacji do anulowania.");
            return;
        }

        anulowanie.anuluj(nrOperacji.toString());
    }

}