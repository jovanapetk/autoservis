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
public class ServisnaUsluga implements Serializable,OpstiDomenskiObjekat{
    private int servisnaUslugaID;
    private VrstaServisneUsluge vrstaServisneUsluge;
    private String nazivServisneUsluge;
    private double vremeTrajanja;
    private double cena;

    public ServisnaUsluga(int servisnaUslugaID, VrstaServisneUsluge vrstaServisneUsluge, String nazivServisneUsluge, double vremeTrajanja, double cena) {
        this.servisnaUslugaID = servisnaUslugaID;
        this.vrstaServisneUsluge = vrstaServisneUsluge;
        this.nazivServisneUsluge = nazivServisneUsluge;
        this.vremeTrajanja = vremeTrajanja;
        this.cena = cena;
    }
    public ServisnaUsluga() {
    }
    
    public int getServisnaUslugaID() {
        return servisnaUslugaID;
    }

    public void setServisnaUslugaID(int servisnaUslugaID) {
        this.servisnaUslugaID = servisnaUslugaID;
    }

    public VrstaServisneUsluge getVrstaServisneUsluge() {
        return vrstaServisneUsluge;
    }

    public void setVrstaServisneUsluge(VrstaServisneUsluge vrstaServisneUsluge) {
        this.vrstaServisneUsluge = vrstaServisneUsluge;
    }

    public double getVremeTrajanja() {
        return vremeTrajanja;
    }

    public void setVremeTrajanja(double vremeTrajanja) {
        this.vremeTrajanja = vremeTrajanja;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int id=rs.getInt("ServisnaUslugaID");
                String nazivUsluge=rs.getString("NazivUsluge");
                double vreme= rs.getDouble("VremeTrajanja");
                double cena= rs.getDouble("Cena");
                int idvrsta=rs.getInt("VrstaServisneUslugeID");
                String nazivVrste=rs.getString("NazivVrste");
                String opisVrste=rs.getString("OpisVrste");
                VrstaServisneUsluge vsu= new VrstaServisneUsluge(idvrsta, nazivVrste, opisVrste);
                ServisnaUsluga su= new ServisnaUsluga(id, vsu, nazivUsluge, vreme, cena);
                lista.add(su);
                
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
        return "servisnausluga";
    }

    @Override
    public String vratiJoin() {
        return " JOIN vrstaservisneusluge ON servisnausluga.VrstaServisneUslugeID=vrstaservisneusluge.VrstaServisneUslugeID ";
    }

    @Override
    public String vratiWhere() {
        return "ServisnaUslugaID='"+servisnaUslugaID+"'";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return "("
                + "'" + servisnaUslugaID + "',"
                + "'" + nazivServisneUsluge + "',"
                + "'" + vremeTrajanja + "',"
                + "'" + cena + "',"
                + "'" + vrstaServisneUsluge.getVrstaServisneUslugeID() + "')";
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return  " NazivUsluge='"+nazivServisneUsluge+"', VremeTrajanja='"+vremeTrajanja+"', Cena='"+cena+"', VrstaServisneUslugeID='"+vrstaServisneUsluge.getVrstaServisneUslugeID()+"'";
    }

    public String getNazivServisneUsluge() {
        return nazivServisneUsluge;
    }

    public void setNazivServisneUsluge(String nazivServisneUsluge) {
        this.nazivServisneUsluge = nazivServisneUsluge;
    }

    @Override
    public String vratiID() {
        return "ServisnaUslugaID";
    }

    @Override
    public String vratiWhereZaKriterijume() {
        return "WHERE vrstaservisneusluge.VrstaServisneUslugeID='"+vrstaServisneUsluge.getVrstaServisneUslugeID()+"'";
    }

    @Override
    public String vratiVrednostZaPretragu() {
        return " * ";
    }

    @Override
    public String toString() {
        return " " + nazivServisneUsluge + " ---------- cena: " + cena*vremeTrajanja;
    }
    
}
