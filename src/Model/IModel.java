package Model;

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
    String[] pobieranieHistorii(int nrRachunku);

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
    void anulowanieOperacji(String nrOperacji);

    void przelew(int nrRachunkuZ, int nrRachunkuNa, float kwota);
}