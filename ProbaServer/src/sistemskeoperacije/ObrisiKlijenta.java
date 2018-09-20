/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import domen.ServisniList;
import izuzetak.SystemOperationException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class ObrisiKlijenta extends OpstaSO{
    private Klijent klijent;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        ServisniList sl= new ServisniList();
        sl.setKlijent((Klijent) objekat);
        ArrayList <OpstiDomenskiObjekat> lista =DBBroker.getInstance().vratiListu(sl);
        if(!lista.isEmpty()){
        throw new SystemOperationException("Na ovog klijenta se vode servisni listovi");
        }
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        klijent = (Klijent) DBBroker.getInstance().obrisi((Klijent)objekat);
    }

    public Klijent getKlijent() {
        return klijent;
    }

}
