package TestyFitnesse;

import Kontroler.*;
import Model.DAO;
import Model.Model;
import Model.SystemBankowy;
import fit.Fixture;

public class SetUp extends Fixture {
    static DAO dao;
    static SystemBankowy systemBankowy;
    static Model model;
    static Drukarka drukarka;
    static DozownikBanknotow dozownik;
    static Monitor monitor;
    static CzytnikKart czytnikKart;
    
    public SetUp() {
        dao = new DAO();
        systemBankowy  = new SystemBankowy(dao);
        model = new Model(dao, systemBankowy);
        drukarka = new Drukarka();
        dozownik = new DozownikBanknotow();
        monitor = new Monitor();
        czytnikKart = new CzytnikKart();
    }

    public static void ustawKwote(float kwota) {
        monitor.ustawKwote(kwota);
        dozownik.ustawKwote(kwota);
    }
}
