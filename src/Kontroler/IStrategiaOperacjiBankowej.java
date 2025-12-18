package Kontroler;

public abstract class IStrategiaOperacjiBankowej {

    protected IModel model;
    protected int nrRachunku;
    protected Drukarka drukarka;
    protected DozownikBanknotow dozownik;
    protected Monitor monitor;

    private void wykonaj() {
        // TODO - implement IStrategiaOperacjiBankowej.wykonaj
        throw new UnsupportedOperationException();
    }

}