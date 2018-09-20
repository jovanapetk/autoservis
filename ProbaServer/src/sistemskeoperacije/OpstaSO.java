/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemskeoperacije;

import dbb.DBBroker;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public abstract class OpstaSO {
    private void uspostaviKonekciju() throws Exception {
        DBBroker.getInstance().uspostaviKonekciju();
    }

    protected abstract void proveriPreduslove(Object objekat) throws Exception;

    protected abstract void izvrsiSO(Object objekat) throws Exception;

    private void commitTransakcije() throws SQLException {
        DBBroker.getInstance().commitTransakcije();
    }

    private void rollBackTransakcije() throws SQLException {
        DBBroker.getInstance().rollbackTransakcije();
    }

    private void zatvoriKonekciju() {
        DBBroker.getInstance().prekiniKonekciju();
    }

    public final synchronized void opsteIzvrsenjeSO(Object objekat) throws Exception {
        try {
            uspostaviKonekciju();
            proveriPreduslove(objekat);
            izvrsiSO(objekat);
            commitTransakcije();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            rollBackTransakcije();
            throw e;
        } finally {
            zatvoriKonekciju();
        }
    }
}
