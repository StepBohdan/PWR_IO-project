package Model;

import java.lang.constant.Constable;
import java.util.*;

public class Model implements IModel {

    private IDAO dao;
    private SystemBankowy systemBankowy;
    
    private final Map<Integer, Float> salda = new HashMap<>();
    private final Map<String, String> operacje = new HashMap<>();
    private final Map<Integer, List<String>> historia = new HashMap<>();

    public Model (IDAO dao, SystemBankowy systemBankowy) {
        this.dao = dao;
        this.systemBankowy = systemBankowy;
    }

    @Override
    public boolean wplacanieSrodkow(int nrRachunku, float kwota) {
        System.out.println("[Model] wplacanieSrodkow(nrRachunku=" + nrRachunku + ", kwota=" + kwota + ")");

        if (kwota <= 0) return false;
        
        boolean sukces = systemBankowy.wykonajWplate(nrRachunku, kwota);

        float obecne = salda.getOrDefault(nrRachunku, 0.0f);
        salda.put(nrRachunku, obecne + kwota);

        return sukces;
    }

    @Override
    public boolean wyplacanieSrodkow(int nrRachunku, float kwota) {
        System.out.println("[Model] wyplacanieSrodkow(nrRachunku=" + nrRachunku + ", kwota=" + kwota + ")");

        if (kwota <= 0) return false;

        float obecne = salda.getOrDefault(nrRachunku, 0.0f);
        if (obecne < kwota) return false;

        float nowe = obecne - kwota;
        salda.put(nrRachunku, nowe);

        String nrOperacji = "NROP-" + System.currentTimeMillis();
        operacje.put(nrOperacji, "Wypłata: -" + kwota + " | saldo po: " + nowe);

        historia.computeIfAbsent(nrRachunku, k -> new ArrayList<>())
                .add("[" + nrOperacji + "] Wypłata -" + kwota + " => saldo: " + nowe);

        boolean sukces = systemBankowy.wykonajWyplate(nrRachunku, kwota);
        
        return sukces;
    }

    @Override
    public String pobieranieDanychKonta(int nrRachunku) {
        System.out.println("[Model] pobieranieDanychKonta(nrRachunku=" + nrRachunku + ")");

        float saldo = salda.getOrDefault(nrRachunku, 0.0f);
        float saldoTest = systemBankowy.pobierzKlienta(nrRachunku).dajSaldo();
        return "Nr rachunku: " + nrRachunku + "\nSaldo: " + saldo;
    }

    @Override
    public String pobieranieDanychOperacji(String nrOperacji) {
        System.out.println("[Model] pobieranieDanychOperacji(nrOperacji=" + nrOperacji + ")");
        IOperacja operacja = systemBankowy.pobierzDaneOperacji(nrOperacji);
        return operacje.getOrDefault(nrOperacji, "Brak danych dla operacji: " + nrOperacji);
    }

    @Override
    public String[] pobieranieHistorii(int nrRachunku) {
        System.out.println("[Model] pobieranieHistorii(nrRachunku=" + nrRachunku + ")");

        int nr;
        try {
            nr = nrRachunku;
        } catch (Exception e) {
            return new String[] { "Niepoprawny nr rachunku: " + nrRachunku };
        }

        List<String> h = historia.getOrDefault(nr, List.of());
        HistoriaOperacji historiaOperacji = systemBankowy.pobierzHistorieOperacji(nrRachunku);
        return h.toArray(new String[0]);
    }

    @Override
    public void anulowanieOperacji(String nrOperacji) {
        System.out.println("[Model] anulowanieOperacji(nrOperacji=" + nrOperacji + ")");
        
        if (operacje.containsKey(nrOperacji)) {
            operacje.put(nrOperacji, operacje.get(nrOperacji) + " [ANULOWANO]");
        }
        
        systemBankowy.anulujOperacje(nrOperacji);
    }

    @Override
    public void przelew(int nrRachunkuZ, int nrRachunkuNa, float kwota) {
        System.out.println("[Model] przelew(nrRachunkuZ=" + nrRachunkuZ + ", nrRachunkuNa=" + nrRachunkuNa + ", kwota=" + kwota + ")");
        if (kwota <= 0) return;

        float obecne = salda.getOrDefault(nrRachunkuZ, 0.0f);
//        if (obecne < kwota) return;

        systemBankowy.wykonajPrzelew(nrRachunkuZ, nrRachunkuNa, kwota);

        float noweZ = obecne - kwota;
        salda.put(nrRachunkuZ, noweZ);

        float noweNa = salda.getOrDefault(nrRachunkuNa, 0.0f) + kwota;
        salda.put(nrRachunkuNa, noweNa);

        String nrOperacji = "NROP-" + System.currentTimeMillis();
        operacje.put(nrOperacji, "Przelew: -" + kwota + " z " + nrRachunkuZ + " na " + nrRachunkuNa);

        historia.computeIfAbsent(nrRachunkuZ, k -> new ArrayList<>())
                .add("[" + nrOperacji + "] Przelew wychodzący -" + kwota + " na " + nrRachunkuNa);
        historia.computeIfAbsent(nrRachunkuNa, k -> new ArrayList<>())
                .add("[" + nrOperacji + "] Przelew przychodzący +" + kwota + " od " + nrRachunkuZ);
    }
}
