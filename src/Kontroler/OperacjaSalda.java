package Kontroler;
import Model.IModel;

public class OperacjaSalda extends IStrategiaOperacjiBankowej {

    /**
     * @param model
     * @param nrRachunku
     * @param monitor
     */
    public OperacjaSalda(IModel model, int nrRachunku, Monitor monitor) {
        if (model == null || monitor == null) {
            throw new IllegalArgumentException("model i monitor nie mogą być null");
        }
        this.model = model;
        this.nrRachunku = nrRachunku;
        this.monitor = monitor;
    }

    @Override
    public void wykonaj() {
        System.out.println("[OperacjaSalda] wykonaj() START nrRachunku=" + nrRachunku);

        String daneKonta = model.pobieranieDanychKonta(nrRachunku);
        System.out.println("[OperacjaSalda] pobrano daneKonta (len=" + (daneKonta == null ? 0 : daneKonta.length()) + ")");

        String saldo = zparsujSaldo(daneKonta);
        System.out.println("[OperacjaSalda] saldo komunikat przygotowany");

        monitor.wyswietl(saldo);

        System.out.println("[OperacjaSalda] wykonaj() END");
    }

    /**
     * @param daneKlienta
     */
    private String zparsujSaldo(String daneKlienta) {
        if (daneKlienta == null || daneKlienta.isBlank()) {
            return "Brak danych konta dla rachunku: " + nrRachunku;
        }

        String lower = daneKlienta.toLowerCase();

        int idx = lower.indexOf("saldo");
        if (idx >= 0) {
            String fragment = daneKlienta.substring(idx);

            int sep = fragment.indexOf(':');
            if (sep < 0) sep = fragment.indexOf('=');

            if (sep >= 0 && sep + 1 < fragment.length()) {
                String wartosc = fragment.substring(sep + 1).trim();
                int nl = wartosc.indexOf('\n');
                if (nl >= 0) wartosc = wartosc.substring(0, nl).trim();

                return "Saldo rachunku " + nrRachunku + ": " + wartosc;
            }
        }

        return "Saldo rachunku " + nrRachunku + ": " + daneKlienta.trim();
    }
}
