package Kontroler;
import Model.IModel;

public class OperacjaHistorii extends IStrategiaOperacjiBankowej {

    private final IModel model;
    private final int nrRachunku;
    private final Monitor monitor;
    private final OperacjaSalda operacjaSalda;

    /**
     * @param model
     * @param nrRachunku
     * @param monitor
     */
    public OperacjaHistorii(IModel model, int nrRachunku, Monitor monitor) {
        if (model == null || monitor == null) {
            throw new IllegalArgumentException("model i monitor nie mogą być null");
        }
        this.model = model;
        this.nrRachunku = nrRachunku;
        this.monitor = monitor;

        this.operacjaSalda = new OperacjaSalda(model, nrRachunku, monitor);
    }

    @Override
    public void wykonaj() {
        // 1.1 / 1.2: pobieranieHistorii(nrRachunku:int) : String[]
        String[] historiaOperacji = model.pobieranieHistorii(nrRachunku);

        // 1.3 / 1.4: komunikat = zparsujHistorie(historiaOperacji)
        String komunikat = zparsujHistorie(historiaOperacji);

        // 2: wyswietl(komunikat)
        monitor.wyswietl(komunikat);

        // 4: wykonaj() -> OperacjaSalda
        operacjaSalda.wykonaj();
    }

    /**
     * @param historia
     */
    private String zparsujHistorie(String[] historia) {
        if (historia == null || historia.length == 0) {
            return "Brak historii operacji dla rachunku: " + nrRachunku;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Historia operacji (rachunek ").append(nrRachunku).append("):\n");

        for (int i = 0; i < historia.length; i++) {
            sb.append(i + 1).append(". ").append(historia[i]).append("\n");
        }

        return sb.toString();
    }
}
