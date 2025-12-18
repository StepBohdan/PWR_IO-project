package Kontroler;
import Model.IModel;

public class OperacjaWydruku {

    private final IModel model;
    private final Drukarka drukarka;
    private final Monitor monitor;
    private final String nrOperacji;

    public OperacjaWydruku(IModel model, Drukarka drukarka, String nrOperacji, IStrategiaOperacjiBankowej operacja, Monitor monitor) {
        if (model == null || drukarka == null || monitor == null) {
            throw new IllegalArgumentException("model/drukarka/monitor nie mogą być null");
        }
        this.model = model;
        this.drukarka = drukarka;
        this.monitor = monitor;
        this.nrOperacji = (nrOperacji == null) ? "" : nrOperacji;
    }



    public void drukuj() {
        // 1.1 / 1.2: daneOperacji = pobieranieDanychOperacji(nrOperacji)
        String daneOperacji = model.pobieranieDanychOperacji(nrOperacji);

        // 1.3 / 1.4: zparsowaneDane = zparsujDaneOperacji(daneOperacji)
        String zparsowaneDane = zparsujDaneOperacji(daneOperacji);

        // 2 / 2.1: zweryfikowano = weryfikujDane(zparsowaneDane)
        boolean zweryfikowano = weryfikujDane(zparsowaneDane);

        // alt
        if (zweryfikowano) {
            // 3: drukuj(dane:String)
            drukarka.drukuj(zparsowaneDane);
        } else {
            // 4: wyswietl(komunikat:String)
            monitor.wyswietl("Nie można wydrukować potwierdzenia — niepoprawne dane operacji.");
        }
    }

    private String zparsujDaneOperacji(String daneOperacji) {
        if (daneOperacji == null) return "";

        // prosty “paragon”
        return "Nr operacji: " + nrOperacji + "\n" + "------------------------------\n" + daneOperacji.trim() + "\n" + "------------------------------\n";
    }

    private boolean weryfikujDane(String dane) {
        return dane != null && !dane.isBlank() && dane.contains("Nr operacji");
    }
}
