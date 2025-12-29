package Kontroler;
import Model.IModel;

public abstract class IStrategiaOperacjiBankowej {
    protected IModel model;
    protected int nrRachunku;
    protected Drukarka drukarka;
    protected DozownikBanknotow dozownik;
    protected Monitor monitor;

    public void wykonaj() {
        throw new UnsupportedOperationException();
    }
}