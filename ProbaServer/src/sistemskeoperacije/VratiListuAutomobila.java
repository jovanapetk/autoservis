/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Automobil;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class VratiListuAutomobila extends OpstaSO{
     private ArrayList<OpstiDomenskiObjekat>lista;
    
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        lista=DBBroker.getInstance().vratiListu((Automobil) objekat);
    }

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
}
