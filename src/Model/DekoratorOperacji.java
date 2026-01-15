package Model;

public abstract class DekoratorOperacji implements IOperacja {
    
    protected IOperacja operacja;
    
    public DekoratorOperacji(IOperacja operacja) {
        if (operacja == null) {
            throw new IllegalArgumentException("Operacja nie może być pusta");
        }
        this.operacja = operacja;
    }

    public String dajNrOperacji() {
        return operacja.dajNrOperacji();
    }

    public Klient dajKlienta() {
        return operacja.dajKlienta();
    }

    public String opisz() {
        return  operacja.opisz();
    }
    
}