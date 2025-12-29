package Kontroler;
import java.util.UUID;
import Model.IModel;

public class KontrolerKlienta {
    private final IModel model;
    private final int nrRachunku;
    private final Drukarka drukarka;
    private final DozownikBanknotow dozownik;
    private final Monitor monitor;
    private final CzytnikKart czytnik;
    private final UUID uuid;
    private IStrategiaOperacjiBankowej strategiaOperacjiBankowej;

    public KontrolerKlienta(IModel model) {
        this.model = model;

        this.monitor = new Monitor();
        this.drukarka = new Drukarka();
        this.dozownik = new DozownikBanknotow();
        this.czytnik = new CzytnikKart();
        this.nrRachunku = 0;
        this.uuid = null;
        this.strategiaOperacjiBankowej = null;
    }

    public void wyplataGotowki() {
        // TODO - implement KontrolerKlienta.wyplataGotowki
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
        System.out.println("[KontrolerKlienta] anulowanieOperacji() START  nrOperacji=" + uuid);

        AnulowanieOperacji anulowanie = new AnulowanieOperacji(model, monitor, czytnik);

        if (uuid == null) {
            System.out.println("[KontrolerKlienta] brak nrOperacji -> STOP");
            monitor.wyswietl("Brak numeru operacji do anulowania.");
            return;
        }

        anulowanie.anuluj(uuid.toString());

        System.out.println("[KontrolerKlienta] anulowanieOperacji() END");
    }

}