/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Klijent;
import izuzetak.SystemOperationException;

/**
 *
 * @author Korisnik
 */
public class NadjiKlijenta extends OpstaSO{
private Klijent klijent;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        klijent=(Klijent) DBBroker.getInstance().nadji((Klijent) objekat);
        if(klijent==null){
        throw new SystemOperationException("Klijent sa ovim jmbg-om ne postoji");
        }
    }

    public Klijent getKlijent() {
        return klijent;
    }
    
}
