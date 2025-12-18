package Kontroler;

public interface IModel {

    /**
     *
     * @param nrRachunku
     */
    String pobieranieDanychKonta(int nrRachunku);

    /**
     *
     * @param nrRachunku
     */
    String[] pobieranieHistorii(String nrRachunku);

    /**
     *
     * @param nrRachunku
     * @param kwota
     */
    boolean wyplacanieSrodkow(int nrRachunku, float kwota);

    /**
     *
     * @param nrRachunku
     * @param kwota
     */
    boolean wplacanieSrodkow(int nrRachunku, float kwota);

    /**
     *
     * @param nrOperacji
     */
    String pobieranieDanychOperacji(String nrOperacji);

    /**
     *
     * @param nrOperacji
     */
    boolean anulowanieOperacji(String nrOperacji);

}