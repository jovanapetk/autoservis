/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.VrstaServisneUsluge;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class VratiListuVrstaServisnihUsluga extends OpstaSO{
private ArrayList<OpstiDomenskiObjekat>lista;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        lista=DBBroker.getInstance().vratiListu(new VrstaServisneUsluge());
        for(OpstiDomenskiObjekat vsu:lista){
         System.out.println("u sist operaciji"+vsu.toString());
        }
    }

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
}
