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
public class StavkaServisnogLista implements Serializable,OpstiDomenskiObjekat{
    private ServisniList servisniList;
    private int redniBrojStavke;
    private double iznos;
    private ServisnaUsluga servisnaUsluga;

    public StavkaServisnogLista() {
    }

    public StavkaServisnogLista(ServisniList servisniList, int redniBrojStavke, double iznos, ServisnaUsluga servisnaUsluga) {
        this.servisniList = servisniList;
        this.redniBrojStavke = redniBrojStavke;
        this.iznos = iznos;
        this.servisnaUsluga = servisnaUsluga;
    }

    public int getRedniBrojStavke() {
        return redniBrojStavke;
    }

    public void setRedniBrojStavke(int redniBrojStavke) {
        this.redniBrojStavke = redniBrojStavke;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public ServisnaUsluga getServisnaUsluga() {
        return servisnaUsluga;
    }

    public void setServisnaUsluga(ServisnaUsluga servisnaUsluga) {
        this.servisnaUsluga = servisnaUsluga;
    }
    
    @Override
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int brstavke=rs.getInt("brojstavke");
               // int brservlista= rs.getInt("brservisnoglista");
                double iznos= rs.getDouble("iznos");
                int servuslID= rs.getInt("servuslID");
                String nazivusl= rs.getString("nazivusluge");
                double vreme= rs.getDouble("vreme");
                double cena= rs.getDouble("cena");
                int vrstasuID=rs.getInt("vrstasuID");
                String nazivvrste= rs.getString("nazivvrste");
                String opisvrste= rs.getString("opisvrste");
                
                VrstaServisneUsluge vsu= new VrstaServisneUsluge(vrstasuID, nazivvrste, opisvrste);
                ServisnaUsluga su= new ServisnaUsluga(servuslID, vsu, nazivusl, vreme, cena);
                StavkaServisnogLista stavka= new StavkaServisnogLista(servisniList, brstavke, iznos, su); // da li treba null ili ovaj argument odozgo?
                lista.add(stavka);
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
        return "stavkaservisnoglista  ";
    }

    @Override
    public String vratiJoin() {
        return " JOIN servisnausluga su on stavkaservisnoglista.ServisnaUslugaID=su.ServisnaUslugaID JOIN vrstaservisneusluge vsu ON su.VrstaServisneUslugeID=vsu.VrstaServisneUslugeID ";
    }

    @Override
    public String vratiWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaInsert() {
        return "("
                + "'" + redniBrojStavke + "',"
                + "'" + servisniList.getBrojServisnogLista() + "',"
                + "'" + iznos + "',"
                + "'" + servisnaUsluga.getServisnaUslugaID() + "')";
    }

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWhereZaKriterijume() {
        return "WHERE BrojServisnogLista='"+servisniList.getBrojServisnogLista()+"' ORDER BY stavkaservisnoglista.BrojStavke ASC";
    }

    public ServisniList getServisniList() {
        return servisniList;
    }

    public void setServisniList(ServisniList servisniList) {
        this.servisniList = servisniList;
    }

    @Override
    public String vratiVrednostZaPretragu() {
        return " stavkaservisnoglista.BrojStavke as brojstavke, stavkaservisnoglista.BrojServisnogLista as brservisnoglista, stavkaservisnoglista.Iznos as iznos, su.ServisnaUslugaID as servuslID, su.NazivUsluge as nazivusluge, su.VremeTrajanja as vreme, su.Cena as cena, vsu.VrstaServisneUslugeID as vrstasuID, vsu.NazivVrste as nazivvrste, vsu.OpisVrste as opisvrste ";
    }
    
}
