package Model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DAO implements IDAO {
    private final Map<Integer, Float> saldo = new ConcurrentHashMap<>();
    private final Map<String, Boolean> operacje = new ConcurrentHashMap<>();

    public DAO() {
        saldo.put(1, 100.0f);
        saldo.put(2, 0.0f);

        operacje.put("OP-1", true);
        operacje.put("OP-2", true);
    }

    /**
     *
     * @param klient
     */
    public void dodajKlienta(String klient) {
        // TODO - implement DAO.dodajKlienta
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrKlienta
     */
    public String pobierzKlienta(int nrKlienta) {
        // TODO - implement DAO.pobierzKlienta
        throw new UnsupportedOperationException();
    }
    
    public float pobierzSaldo(int nrKlienta) {
        return saldo.getOrDefault(nrKlienta, 0.0f);
    }

    public void dodajSaldo(int nrKlienta, float kwota) {
        saldo.put(nrKlienta, pobierzSaldo(nrKlienta) + kwota);
    }
    
    public boolean istniejeKonto(int nrKlienta) {
        return saldo.containsKey(nrKlienta);
    }

    /**
     *
     * @param klient
     */
    public void edytujKlienta(String klient) {
        // TODO - implement DAO.edytujKlienta
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrKlienta
     */
    public void usunKlienta(int nrKlienta) {
        // TODO - implement DAO.usunKlienta
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param nrKlienta
     * @param iloscOperacji
     */
    public String[] pobierzHistorieOperacjiKlienta(int nrKlienta, int iloscOperacji) {
        // TODO - implement DAO.pobierzHistorieOperacjiKlienta
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param operacja
     */
    public void dodajOperacje(String operacja) {
        operacje.put(operacja, true);
    }

    @Override
    public boolean pobierzOperacje(String nrOperacji) {
        return operacje.getOrDefault(nrOperacji, false);
    }

    /**
     *
     * @param nrOperacji
     */
    public void usunOperacja(String nrOperacji) {
        if (operacje.containsKey(nrOperacji)) {
            operacje.put(nrOperacji, false);
        }
    }

}