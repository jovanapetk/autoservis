/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Klijent;
import izuzetak.SystemOperationException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class ZapamtiKlijenta extends OpstaSO{

    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        Klijent klijent=(Klijent) DBBroker.getInstance().nadji((Klijent) objekat);
        if(klijent!=null){
        throw new SystemOperationException("Klijent sa ovim jmbg-om vec postoji");
        }
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        DBBroker.getInstance().sacuvaj((Klijent)objekat);
    }
    
}
