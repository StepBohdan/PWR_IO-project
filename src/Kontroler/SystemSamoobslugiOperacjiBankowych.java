package Kontroler;

import Model.Model;

public class SystemSamoobslugiOperacjiBankowych {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("[SystemSamoobslugiOperacjiBankowych] main() START");

        try {
            // 1) model
            System.out.println("[System] Tworzenie modelu...");
            Model model = new Model();

            // 2) kontroler klienta
            System.out.println("[System] Tworzenie KontrolerKlienta...");
            KontrolerKlienta kontroler = new KontrolerKlienta(model);

            // 3) przykładowe wywołanie (test)
            System.out.println("[System] Uruchamiam: wplataGotowki()");
            kontroler.wplataGotowki();


        } catch (UnsupportedOperationException e) {
            System.out.println("[System] NIEZAIMPLEMENTOWANE: " + e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("[System] BŁĄD: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("[SystemSamoobslugiOperacjiBankowych] main() END");
    }

}