/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Korisnik
 */
public class ServisniList implements Serializable,OpstiDomenskiObjekat{
    private int brojServisnogLista;
    private Date datumServisiranja;
    private double ukupnaCena;
    private Klijent klijent;
    private ArrayList<StavkaServisnogLista> listaStavkiServisnogLista;
    // double popust; ako postoji >5 Serv listova na klijentovo ime 10% a >10 20%
    private Korisnik korisnik;
    private Automobil automobil;
    public ServisniList() {
    }

    public ServisniList(int brojServisnogLista, Date datumServisiranja, double ukupnaCena, Klijent klijent, ArrayList<StavkaServisnogLista> listaStavkiServisnogLista, Korisnik korisnik, Automobil automobil) {
        this.brojServisnogLista = brojServisnogLista;
        this.datumServisiranja = datumServisiranja;
        this.ukupnaCena = ukupnaCena;
        this.klijent = klijent;
        this.listaStavkiServisnogLista = listaStavkiServisnogLista;
        this.korisnik = korisnik;
        this.automobil = automobil;
    }

    
    public int getBrojServisnogLista() {
        return brojServisnogLista;
    }

    public void setBrojServisnogLista(int brojServisnogLista) {
        this.brojServisnogLista = brojServisnogLista;
    }

    public Date getDatumServisiranja() {
        return datumServisiranja;
    }

    public void setDatumServisiranja(Date datumServisiranja) {
        this.datumServisiranja = datumServisiranja;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public ArrayList<StavkaServisnogLista> getListaStavkiServisnogLista() {
        return listaStavkiServisnogLista;
    }

    public void setListaStavkiServisnogLista(ArrayList<StavkaServisnogLista> listaStavkiServisnogLista) {
        this.listaStavkiServisnogLista = listaStavkiServisnogLista;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception {
        try {
            ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
            while (rs.next()) {
                int brsl= rs.getInt("brsl");
                Date datum=new Date(rs.getDate("datum").getTime());
                double ukupnacena= rs.getDouble("ukupnacena");
                String jmbg=rs.getString("jmbg");
                String ime=rs.getString("ime");
                String prezime=rs.getString("prezime");
                String brZiroRacuna=rs.getString("brZiroRacuna");
                String username=rs.getString("username");
                String password=rs.getString("password");
                String imekor=rs.getString("imekor");
                String prezimekor=rs.getString("prezimekor");
                int km=rs.getInt("km");
                int godiste=rs.getInt("godiste");
                String regbr=rs.getString("regbr");
                Date regdo=new Date(rs.getDate("regdo").getTime());
                int modelid=rs.getInt("modelid");
                String nazivmodela=rs.getString("nazivmodela");
                String pogon=rs.getString("pogon");
                int proizvodjacID=rs.getInt("proizvodjacID");
                String nazivproizv=rs.getString("nazivproizv");
                Proizvodjac proizvodjac= new Proizvodjac(proizvodjacID, nazivproizv);
                Model model= new Model(modelid, nazivmodela, pogon, proizvodjac);
                Automobil automobil= new Automobil(regbr, godiste, km, regdo, model);
                Klijent k= new Klijent(jmbg, ime, prezime, brZiroRacuna);
                Korisnik kor= new Korisnik(username, password, imekor, prezimekor);
                ServisniList sl= new ServisniList(brsl, datum, ukupnacena, k, new ArrayList<>(),kor,automobil);
                lista.add(sl);
            }
           return lista;
        } catch (SQLException ex) {
            throw new Exception("Greška pri učitavanju servisnih listova!");
        }
    }

    @Override
    public void postavi(OpstiDomenskiObjekat odo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivTabele() {
        return "servisnilist";
    }

    @Override
    public String vratiJoin() {
        return "LEFT JOIN klijent on servisnilist.JMBG=klijent.JMBG JOIN korisnik ON servisnilist.username=korisnik.username JOIN automobil ON servisnilist.RegistarskiBroj=automobil.RegistarskiBroj LEFT JOIN model on model.ModelID=automobil.ModelID LEFT JOIN proizvodjac on proizvodjac.ProizvodjacID=model.ModelID";
    }

    @Override
    public String vratiWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaInsert() {
        return "("
                + "'" + brojServisnogLista + "',"
                + "'" + new Timestamp(datumServisiranja.getTime()) + "',"  //proveri ovo
                + "'" + ukupnaCena + "',"
                + "'" + klijent.getJmbg() + "',"
                + "'" + korisnik.getUsername() + "',"
                + "'" + automobil.getRegistarskiBroj() + "')";
    }

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiID() {
        return "BrojServisnogLista";
    }

    @Override
    public String vratiWhereZaKriterijume() {
        return "WHERE klijent.JMBG='"+klijent.getJmbg()+"'";
    }

    @Override
    public String vratiVrednostZaPretragu() {
        return " servisnilist.BrojServisnogLista as brsl, servisnilist.DatumServisiranja as datum, servisnilist.UkupnaCena as ukupnacena, klijent.JMBG as jmbg, klijent.Ime as ime, klijent.Prezime as prezime, klijent.BrojZiroRacuna as brZiroRacuna, korisnik.username as username, korisnik.password as password, korisnik.ime as imekor, korisnik.prezime as prezimekor, automobil.Kilometraza as km, automobil.Godiste as godiste, automobil.RegistarskiBroj as regbr,automobil.RegistrovanDo as regdo, model.ModelID as modelid, model.NazivModela as nazivmodela, model.Pogon as pogon, proizvodjac.ProizvodjacID as proizvodjacID, proizvodjac.NazivProizvodjaca as nazivproizv ";
    }

    @Override
    public String toString() {
        return "Servisni list broj: " +brojServisnogLista+" na datum: "+datumServisiranja ;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }
    
}
