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
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class Automobil implements Serializable,OpstiDomenskiObjekat{
private String registarskiBroj;
private int godiste;
private int kilometraza;
private Date registrovanDo;
private Model model;

    public Automobil() {
    }

    public Automobil(String registarskiBroj, int godiste, int kilometraza, Date registrovanDo, Model model) {
        this.registarskiBroj = registarskiBroj;
        this.godiste = godiste;
        this.kilometraza = kilometraza;
        this.registrovanDo = registrovanDo;
        this.model = model;
    }
    

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int km=rs.getInt("Kilometraza");
                int godiste=rs.getInt("Godiste");
                String regbr=rs.getString("RegistarskiBroj");
                Date regdo=new Date(rs.getDate("RegistrovanDo").getTime());
                int modelid=rs.getInt("ModelID");
                String nazivmodela=rs.getString("NazivModela");
                String pogon=rs.getString("Pogon");
                int proizvodjacID=rs.getInt("ProizvodjacID");
                String nazivproizv=rs.getString("NazivProizvodjaca");
                Proizvodjac proizvodjac= new Proizvodjac(proizvodjacID, nazivproizv);
                Model model= new Model(modelid, nazivmodela, pogon, proizvodjac);
                Automobil automobil= new Automobil(regbr, godiste, km, regdo, model);
                lista.add(automobil);
                
            }
           return lista;
        } catch (SQLException ex) {
            throw new Exception("Greška pri učitavanju automobila!");
        }
    }

    @Override
    public void postavi(OpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "automobil";
    }

    @Override
    public String vratiJoin() {
        return "JOIN model on automobil.ModelID=model.ModelID JOIN proizvodjac on model.ProizvodjacID=proizvodjac.ProizvodjacID";
    }

    @Override
    public String vratiWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String vratiVrednostZaPretragu() {
        return "*";
    }

    @Override
    public String vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWhereZaKriterijume() {
        return "WHERE automobil.RegistarskiBroj LIKE '"+registarskiBroj+"%'";
    }

    public String getRegistarskiBroj() {
        return registarskiBroj;
    }

    public void setRegistarskiBroj(String registarskiBroj) {
        this.registarskiBroj = registarskiBroj;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public int getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(int kilometraza) {
        this.kilometraza = kilometraza;
    }

    public Date getRegistrovanDo() {
        return registrovanDo;
    }

    public void setRegistrovanDo(Date registrovanDo) {
        this.registrovanDo = registrovanDo;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
}
