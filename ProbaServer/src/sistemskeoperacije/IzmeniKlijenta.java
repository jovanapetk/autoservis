/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Korisnik
 */
public class IzmeniKlijenta extends OpstaSO{
private Klijent klijent;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
    klijent = (Klijent) DBBroker.getInstance().izmeni((Klijent) objekat);
    }

    public Klijent getKlijent() {
        return klijent;
    }

    
}
