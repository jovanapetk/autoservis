/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import domen.Klijent;
import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class DBBroker {
    Connection konekcija;
    private static DBBroker instance;

    private DBBroker() {

    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }
    public void ucitajDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void uspostaviKonekciju() throws IOException, SQLException {
    DBUtil util = new DBUtil();
        String url = util.vratiURL();
        String user = util.vratiKorisnika();
        String pass = util.vratiSifru();
        konekcija = DriverManager.getConnection(url, user, pass);
        konekcija.setAutoCommit(false);
        System.out.println("Uspostavljena konekcija sa bazom.");
        
    }
    public void prekiniKonekciju(){
    if(konekcija!=null){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    public void commitTransakcije(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void rollbackTransakcije(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<OpstiDomenskiObjekat> vratiListu(OpstiDomenskiObjekat odo) throws SQLException, Exception {
        String upit = "SELECT " +odo.vratiVrednostZaPretragu()+ " FROM " + odo.vratiNazivTabele() + "  "+odo.vratiJoin()+" " +odo.vratiWhereZaKriterijume(); 
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        return odo.napuni(st.executeQuery(upit));
    } 
    public OpstiDomenskiObjekat izmeni(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostZaUpdate() + " WHERE " + odo.vratiWhere();
        Statement st = konekcija.createStatement();
        System.out.println(upit);
        st.executeUpdate(upit);
        System.out.println("Izmenjen red tabele " + odo.vratiNazivTabele());
        return odo;
    }
    public OpstiDomenskiObjekat obrisi(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiWhere();
        Statement st = konekcija.createStatement();
        System.out.println(upit);
        st.execute(upit);
        return odo;
    }
    public OpstiDomenskiObjekat nadji(OpstiDomenskiObjekat odo) throws Exception{
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " +odo.vratiWhere(); //ovde ima i odo.vratiJoin(); iodo.vratiUslovZaPretragu()
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ArrayList<OpstiDomenskiObjekat> lista=odo.napuni(st.executeQuery(upit));
        if(lista.isEmpty()){
        return null;
        }else return lista.get(0);
    }
    public OpstiDomenskiObjekat sacuvaj(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES " + odo.vratiVrednostZaInsert();
        Statement st = konekcija.createStatement();
        System.out.println(upit);
        st.executeUpdate(upit);
        System.out.println("Sacuvan " + odo.vratiNazivTabele());
        return odo;
    }
    public int vratiRedniBroj(OpstiDomenskiObjekat odo) throws Exception{
        int maks = 0;
        String upit = "SELECT MAX("+odo.vratiID()+") as maks from "+odo.vratiNazivTabele();
        System.out.println(upit);
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        while (rs.next()) {            
            maks = rs.getInt("maks");
        }
        
        rs.close();
        st.close();
        
        return maks + 1;
    }
}
