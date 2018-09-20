/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import domen.ServisnaUsluga;

/**
 *
 * @author Korisnik
 */
public class IzmeniServisnuUslugu extends OpstaSO{
    private ServisnaUsluga servisnaUsluga;
    @Override
    protected void proveriPreduslove(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsiSO(Object objekat) throws Exception {
        servisnaUsluga = (ServisnaUsluga) DBBroker.getInstance().izmeni((ServisnaUsluga) objekat);
    }

    public ServisnaUsluga getServisnaUsluga() {
        return servisnaUsluga;
    }
    
}
