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
        System.out.println("[KontrolerKlienta] utworzono strategię: " + strategiaOperacjiBankowej.getClass().getSimpleName());

        // 1.2: wykonaj()
        strategiaOperacjiBankowej.wykonaj();

        System.out.println("[KontrolerKlienta] wplataGotowki() END");
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
        System.out.println("[KontrolerKlienta] anulowanieOperacji() START  nrOperacji=" + nrOperacji);

        AnulowanieOperacji anulowanie = new AnulowanieOperacji(model, monitor, czytnik);

        if (nrOperacji == null) {
            System.out.println("[KontrolerKlienta] brak nrOperacji -> STOP");
            monitor.wyswietl("Brak numeru operacji do anulowania.");
            return;
        }

        anulowanie.anuluj(nrOperacji.toString());

        System.out.println("[KontrolerKlienta] anulowanieOperacji() END");
    }

}