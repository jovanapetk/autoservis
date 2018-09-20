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
import domen.StavkaServisnogLista;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class NadjiServisneListove extends OpstaSO{
private ArrayList<OpstiDomenskiObjekat>lista;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        lista= new ArrayList<>();
        ServisniList sl= (ServisniList) objekat;
        ArrayList<OpstiDomenskiObjekat> lista1=DBBroker.getInstance().vratiListu(sl);
        for(OpstiDomenskiObjekat odo:lista1){
        ServisniList servisni=(ServisniList) odo;
        StavkaServisnogLista stavka1= new StavkaServisnogLista();
        stavka1.setServisniList(servisni);
        ArrayList<OpstiDomenskiObjekat> listaStavki=DBBroker.getInstance().vratiListu(stavka1);
        ArrayList<StavkaServisnogLista> listaStavki1=new ArrayList<>();
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaStavki) {
                StavkaServisnogLista st=(StavkaServisnogLista) opstiDomenskiObjekat;
                listaStavki1.add(st);
            }
            servisni.setListaStavkiServisnogLista(listaStavki1);
            lista.add(servisni);
        }
        
    }

    public ArrayList<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
}
