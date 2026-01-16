package Model;

import java.util.ArrayList;
import java.util.List;

public class HistoriaOperacji {

    private final List<IOperacja> listaOperacji = new ArrayList<>();

    /**
     *
     * @param operacja
     */
    public boolean dodajOperacje(IOperacja operacja) {
        if (operacja == null) {
            return false;
        }
        return listaOperacji.add(operacja);
    }

    /**
     *
     * @param nrOperacji
     */
    public boolean usunOperacje(String nrOperacji) {
        return listaOperacji.removeIf(op -> op.dajNrOperacji().equals(nrOperacji));
    }

    public IOperacja[] dajHistorieOperacji() {
        return listaOperacji.toArray(new IOperacja[0]);
    }

    public String[] opisz() {
        return listaOperacji.stream()
                .map(IOperacja::opisz)
                .toArray(String[]::new);
    }

}