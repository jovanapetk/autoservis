/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import izuzetak.SystemOperationException;

/**
 *
 * @author Korisnik
 */
public class Logovanje extends OpstaSO{
private Korisnik korisnik;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
       
        korisnik = (Korisnik) DBBroker.getInstance().nadji((Korisnik) objekat);
        if(korisnik==null){
        throw new SystemOperationException("Pogresan username ili password");
        }
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    
}
