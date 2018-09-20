/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.Klijent;
import domen.ServisnaUsluga;

/**
 *
 * @author Korisnik
 */
public class ZapamtiServisnuUslugu extends OpstaSO{

    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        ServisnaUsluga servisnaUsluga=(ServisnaUsluga) objekat;
        int id=DBBroker.getInstance().vratiRedniBroj(servisnaUsluga);
        servisnaUsluga.setServisnaUslugaID(id);
        DBBroker.getInstance().sacuvaj(servisnaUsluga);
    }
    
}
