package Kontroler;
import Model.IModel;

public class OperacjaWydruku {

    private final IModel model;
    private final Drukarka drukarka;
    private final Monitor monitor;
    private final String nrOperacji;

    public OperacjaWydruku(IModel model, Drukarka drukarka, String nrOperacji, Monitor monitor) {
        this.model = model;
        this.drukarka = drukarka;
        this.monitor = monitor;
        this.nrOperacji = nrOperacji;
    }



    public void drukuj() {
        System.out.println("[OperacjaWydruku] drukuj() START nrOperacji=" + nrOperacji);

        String daneOperacji = model.pobieranieDanychOperacji(nrOperacji);
        System.out.println("[OperacjaWydruku] pobrano daneOperacji (len=" + (daneOperacji == null ? 0 : daneOperacji.length()) + ")");

        String zparsowaneDane = zparsujDaneOperacji(daneOperacji);
        System.out.println("[OperacjaWydruku] zparsowaneDane (len=" + zparsowaneDane.length() + ")");

        boolean zweryfikowano = weryfikujDane(zparsowaneDane);
        System.out.println("[OperacjaWydruku] weryfikujDane -> " + zweryfikowano);

        if (zweryfikowano) {
            System.out.println("[OperacjaWydruku] DRUKUJĘ...");
            drukarka.drukuj(zparsowaneDane);
        } else {
            System.out.println("[OperacjaWydruku] NIE DRUKUJĘ -> komunikat na monitor");
            monitor.wyswietl("Nie można wydrukować potwierdzenia — niepoprawne dane operacji.");
        }

        System.out.println("[OperacjaWydruku] drukuj() END");
    }

    private String zparsujDaneOperacji(String daneOperacji) {
        if (daneOperacji == null) return "";

        return "Nr operacji: " + nrOperacji + "\n" + "------------------------------\n" + daneOperacji.trim() + "\n" + "------------------------------\n";
    }

    private boolean weryfikujDane(String dane) {
        return dane != null && !dane.isBlank() && dane.contains("Nr operacji");
    }
}
