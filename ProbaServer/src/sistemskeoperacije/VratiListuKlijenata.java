/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class VratiListuKlijenata extends OpstaSO{
private ArrayList<OpstiDomenskiObjekat>lista;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
       
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        lista=DBBroker.getInstance().vratiListu(new Klijent());
        for(OpstiDomenskiObjekat k:lista){
            System.out.println("u sist operaciji"+k.toString());
        }
    }

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

}
