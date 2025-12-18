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
        System.out.println("[OperacjaHistorii] wykonaj() START nrRachunku=" + nrRachunku);

        String[] historiaOperacji = model.pobieranieHistorii(nrRachunku);
        System.out.println("[OperacjaHistorii] pobrano historię: " + (historiaOperacji == null ? "null" : historiaOperacji.length + " pozycji"));

        String komunikat = zparsujHistorie(historiaOperacji);
        monitor.wyswietl(komunikat);

        System.out.println("[OperacjaHistorii] wykonaj() END");
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
