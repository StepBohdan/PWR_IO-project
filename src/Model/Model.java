package Model;

import java.lang.classfile.instruction.ReturnInstruction;
import java.util.*;

public class Model implements IModel {

    private IDAO dao;
    private SystemBankowy systemBankowy;

    // простая “база” в памяти
    private final Map<Integer, Float> salda = new HashMap<>();
    private final Map<String, String> operacje = new HashMap<>();
    private final Map<Integer, List<String>> historia = new HashMap<>();

    public Model (IDAO dao, SystemBankowy systemBankowy) {
        this.dao = dao;
        this.systemBankowy = systemBankowy;
//        // стартовые данные
//        salda.put(0, 0.0f);
//        historia.put(0, new ArrayList<>());
//        System.out.println("[Model] init");
    }

    @Override
    public boolean wplacanieSrodkow(int nrRachunku, float kwota) {
        System.out.println("[Model] wplacanieSrodkow(nrRachunku=" + nrRachunku + ", kwota=" + kwota + ")");

        if (kwota <= 0) return false;
        
        boolean sukces = systemBankowy.wykonajWplate(nrRachunku, kwota);

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

        return true;
    }

    @Override
    public String pobieranieDanychKonta(int nrRachunku) {
        System.out.println("[Model] pobieranieDanychKonta(nrRachunku=" + nrRachunku + ")");

        float saldo = salda.getOrDefault(nrRachunku, 0.0f);
        return "Nr rachunku: " + nrRachunku + "\nSaldo: " + saldo;
    }

    @Override
    public String pobieranieDanychOperacji(String nrOperacji) {
        System.out.println("[Model] pobieranieDanychOperacji(nrOperacji=" + nrOperacji + ")");
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
        return h.toArray(new String[0]);
    }

    @Override
    public boolean anulowanieOperacji(String nrOperacji) {
        System.out.println("[Model] anulowanieOperacji(nrOperacji=" + nrOperacji + ")");

        // минимальная заглушка: если операция известна — “анулируем”
        if (operacje.containsKey(nrOperacji)) {
            operacje.put(nrOperacji, operacje.get(nrOperacji) + " [ANULOWANO]");
            return true;
        }
        return false;
    }
}
