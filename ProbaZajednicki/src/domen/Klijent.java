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
public class Klijent implements Serializable,OpstiDomenskiObjekat{
    private String jmbg;
    private String ime;
    private String prezime;
    private String brojZiroRacuna;
    
    

    public Klijent(String jmbg, String ime, String prezime, String brojZiroRacuna) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.brojZiroRacuna = brojZiroRacuna;
       
       
    }

    public Klijent() {
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojZiroRacuna() {
        return brojZiroRacuna;
    }

    public void setBrojZiroRacuna(String brojZiroRacuna) {
        this.brojZiroRacuna = brojZiroRacuna;
    }

   
    
    @Override
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                String jmbgS=rs.getString("JMBG");
                String imeS=rs.getString("Ime");
                String prezimeS=rs.getString("Prezime");
                String brZiroRacunaS=rs.getString("BrojZiroRacuna");
                Klijent klijent= new Klijent(jmbgS, imeS, prezimeS, brZiroRacunaS);
                lista.add(klijent);
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
        return "klijent";
    }

    @Override
    public String vratiJoin() {
       return "";
    }

    @Override
    public String vratiWhere() {
        return "JMBG='"+jmbg+"'";
    }

    @Override
    public String vratiVrednostZaInsert() {
        return "("
                + "'" + jmbg + "',"
                + "'" + ime + "',"
                + "'" + prezime + "',"
                + "'" + brojZiroRacuna + "')";
                
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return  " Ime='"+ime+"', Prezime='"+prezime+"', BrojZiroRacuna='"+brojZiroRacuna+"'";
                
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
