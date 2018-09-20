/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.ServisniList;
import domen.StavkaServisnogLista;

/**
 *
 * @author Korisnik
 */
public class ZapamtiServisniList extends OpstaSO{

    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {

    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        ServisniList servisniList=(ServisniList) objekat;
        int rb=DBBroker.getInstance().vratiRedniBroj(servisniList);
        System.out.println("RbServisnog lista je"+rb);
        servisniList.setBrojServisnogLista(rb);
        DBBroker.getInstance().sacuvaj(servisniList);
       
        for (StavkaServisnogLista stavka:servisniList.getListaStavkiServisnogLista()){
        stavka.setServisniList(servisniList);
            System.out.println("Rb stavke je :" +stavka.getRedniBrojStavke()+"");
        DBBroker.getInstance().sacuvaj(stavka);
        }
    }
    
}
