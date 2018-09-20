/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class VrstaServisneUsluge implements Serializable,OpstiDomenskiObjekat{
    private int vrstaServisneUslugeID;
    private String vrstaServisneUsluge;
    private String opisVrsteServisneUsluge;

    public VrstaServisneUsluge() {
    }

    public VrstaServisneUsluge(int vrstaServisneUslugeID, String vrstaServisneUsluge, String opisVrsteServisneUsluge) {
        this.vrstaServisneUslugeID = vrstaServisneUslugeID;
        this.vrstaServisneUsluge = vrstaServisneUsluge;
        this.opisVrsteServisneUsluge = opisVrsteServisneUsluge;
    }

    public int getVrstaServisneUslugeID() {
        return vrstaServisneUslugeID;
    }

    public void setVrstaServisneUslugeID(int vrstaServisneUslugeID) {
        this.vrstaServisneUslugeID = vrstaServisneUslugeID;
    }

    public String getOpisVrsteServisneUsluge() {
        return opisVrsteServisneUsluge;
    }

    public void setOpisVrsteServisneUsluge(String opisVrsteServisneUsluge) {
        this.opisVrsteServisneUsluge = opisVrsteServisneUsluge;
    }
    
    @Override
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int id=rs.getInt("VrstaServisneUslugeID");
                String nazivVrste=rs.getString("NazivVrste");
                String opisVrste=rs.getString("OpisVrste");
                VrstaServisneUsluge vsu= new VrstaServisneUsluge(id, nazivVrste, opisVrste);
                lista.add(vsu);
            }
           return lista;
        } catch (SQLException ex) {
            throw new Exception("Greška pri učitavanju klijenata!");
        }
    }

    @Override
    public void postavi(OpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "vrstaservisneusluge vsu";
    }

    @Override
    public String vratiJoin() {
        return " ";
        //return "vrstaservisneusluge vsu JOIN servisnausluga su ON vsu.VrstaServisneUslugeID=su.VrstaServisneUslugeID";
    }

    @Override
    public String vratiWhere() {
       return "vsu.VrstaServisneUsluge='"+vrstaServisneUslugeID+"'";
    }

    @Override
    public String vratiVrednostZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return vrstaServisneUsluge ;
    }

    public String getVrstaServisneUsluge() {
        return vrstaServisneUsluge;
    }

    public void setVrstaServisneUsluge(String vrstaServisneUsluge) {
        this.vrstaServisneUsluge = vrstaServisneUsluge;
    }

    @Override
    public String vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWhereZaKriterijume() {
        return "";
    }

    @Override
    public String vratiVrednostZaPretragu() {
        return " * ";
    }
    
}
