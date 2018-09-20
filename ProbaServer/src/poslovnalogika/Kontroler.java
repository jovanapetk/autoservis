/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import dbb.DBBroker;
import domen.Automobil;
import domen.Klijent;
import domen.Korisnik;
import domen.ServisnaUsluga;
import domen.ServisniList;
import domen.VrstaServisneUsluge;
import forme.FrmServer;
import izuzetak.SystemOperationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahtevaNit;
import sistemskeoperacije.IzmeniKlijenta;
import sistemskeoperacije.IzmeniServisnuUslugu;
import sistemskeoperacije.Logovanje;
import sistemskeoperacije.NadjiKlijenta;
import sistemskeoperacije.NadjiServisneListove;
import sistemskeoperacije.NadjiServisneUslugeIzVrste;
import sistemskeoperacije.ObrisiKlijenta;
import sistemskeoperacije.OpstaSO;
import sistemskeoperacije.VratiListuAutomobila;
import sistemskeoperacije.VratiListuKlijenata;
import sistemskeoperacije.VratiListuVrstaServisnihUsluga;
import sistemskeoperacije.ZapamtiKlijenta;
import sistemskeoperacije.ZapamtiServisniList;
import sistemskeoperacije.ZapamtiServisnuUslugu;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class Kontroler {
    FrmServer forma;
    private static Kontroler instance;
    public DBBroker dbb;
    ArrayList<ObradaKlijentskihZahtevaNit> listaKorisnika=new ArrayList<>();
    private Kontroler() {
      
    }
    
    public static Kontroler getInstance(){
    if(instance==null){
        instance=new Kontroler();
    }
    return instance;
    }
    OpstaSO oso;
    ServerskiOdgovor odgovor;

    public ServerskiOdgovor vratiListuKlijenata() {
        oso = new VratiListuKlijenata();
        try {
            oso.opsteIzvrsenjeSO(new Klijent());
            odgovor = new ServerskiOdgovor(((VratiListuKlijenata) oso).getLista(), "Sistem je nasao klijente.",null);    //Odgovor(((UcitajMesta) oso).getMesta(), true, "");
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da nadje klijente.",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor izmeniKlijenta(Klijent klijent){
        oso= new IzmeniKlijenta();
         try {
            oso.opsteIzvrsenjeSO(klijent);
            odgovor = new ServerskiOdgovor(null, "Sistem je izmenio klijenta.",null);    
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da izmeni klijenta.",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor obrisiKlijenta(Klijent klijent){
        oso= new ObrisiKlijenta();
         try {
            oso.opsteIzvrsenjeSO(klijent);
            odgovor = new ServerskiOdgovor(null, "Sistem je obrisao klijenta",null);    
        } 
         catch (SystemOperationException soex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, soex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da obrise klijenta. \n "+soex.getLocalizedMessage(),soex);
           //odgovor= new ServerskiOdgovor(null,"Sistem ne moze da obrise klijenta.",soex);
        }
         catch (Exception ex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da obrise klijenta.",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor zapamtiKlijenta(Klijent klijent){
        oso= new ZapamtiKlijenta();
         try {
            oso.opsteIzvrsenjeSO(klijent);
            odgovor = new ServerskiOdgovor(null, "Sistem je zapamtio novog klijenta",null);    
        }
         catch (SystemOperationException soex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, soex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da zapamti novog klijenta. \n "+soex.getLocalizedMessage() ,soex);
        }catch (Exception ex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da zapamti novog klijenta",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor nadjiKlijenta(Klijent klijent){
        oso= new NadjiKlijenta();
         try {
            oso.opsteIzvrsenjeSO(klijent);
            odgovor = new ServerskiOdgovor(((NadjiKlijenta) oso).getKlijent(), "Sistem je nasao klijenta.",null);    
        } 
         catch (SystemOperationException soex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, soex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da nadje klijenta.",soex);
          
        }catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da nadje klijenta.",ex);
        }
        return odgovor;
    }

    public ServerskiOdgovor vratiListuVrstaServisnihUsluga() {
        oso = new VratiListuVrstaServisnihUsluga();
        try {
            oso.opsteIzvrsenjeSO(new VrstaServisneUsluge());
            odgovor = new ServerskiOdgovor(((VratiListuVrstaServisnihUsluga) oso).getLista(), "Lista vrsti servisnih usluga je uspesno ucitana",null); 
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Lista vrsti servisnih usluga nije ucitana",ex);
        }
        return odgovor;
    }

    public ServerskiOdgovor zapamtiServisnuUslugu(ServisnaUsluga servisnaUsluga) {
         oso= new ZapamtiServisnuUslugu();
         try {
            oso.opsteIzvrsenjeSO(servisnaUsluga);
            odgovor = new ServerskiOdgovor(null, "Sistem je zapamtio servisnu uslugu",null);    
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da zapamti servisnu uslugu.",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor izmeniServisnuUslugu(ServisnaUsluga servisnaUsluga) {
         oso= new IzmeniServisnuUslugu();
         try {
            oso.opsteIzvrsenjeSO(servisnaUsluga);
            odgovor = new ServerskiOdgovor(null, "Sistem je izmenio servisnu uslugu.",null);    
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da izmeni servisnu uslugu.",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor nadjiServisneUslugeIzVrste(ServisnaUsluga servisnaUsluga) {
        oso = new NadjiServisneUslugeIzVrste();
        try {
            oso.opsteIzvrsenjeSO(servisnaUsluga);
            odgovor = new ServerskiOdgovor(((NadjiServisneUslugeIzVrste) oso).getLista(), "Sistem je nasao servisne usluge",null); 
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da nadje servisne usluge",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor zapamtiServisniList(ServisniList servisniList) {
         oso= new ZapamtiServisniList();
         try {
            oso.opsteIzvrsenjeSO(servisniList);
            odgovor = new ServerskiOdgovor(null, "Sistem je zapamtio servisni list.",null);    
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne može da zapamti servisni list",ex);
        }
        return odgovor;
    }
    public ServerskiOdgovor logovanje(Korisnik korisnik){
        oso= new Logovanje();
         try {
            oso.opsteIzvrsenjeSO(korisnik);
            Korisnik k=((Logovanje) oso).getKorisnik();
             daLiJeAktivan(k);
            odgovor = new ServerskiOdgovor(((Logovanje) oso).getKorisnik(), "Uspesno logovanje.",null);    
        } 
         catch (SystemOperationException soex) {
            //Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, soex);
            odgovor= new ServerskiOdgovor(null,"Neuspesno logovanje.",soex);
        }catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Neuspesno logovanje.",ex);
        }
        return odgovor;
    }
    public void daLiJeAktivan(Korisnik k) throws Exception {
        for (ObradaKlijentskihZahtevaNit okznit : listaKorisnika) {
            if (okznit.getKorisnik().equals(k)) {
                throw new Exception("Korisnik je već ulogovan!");
            }
        }
    }
     public void registrujKorisnika(ObradaKlijentskihZahtevaNit okznit) {
        listaKorisnika.add(okznit);
        System.out.println("Novi korisnik je registrovan u listu aktivnih.");
        
        forma.promeni(listaKorisnika);
    }
     /*
    public void obavestiSve(ServerskiOdgovor odgovor) {                          
         for (ObradaKlijentskihZahtevaNit okznit : listaKorisnika) {
              okznit.posaljiOdgovor(odgovor);
        }
    }
    */
    public void izlogujSe(ObradaKlijentskihZahtevaNit okznit) {
        okznit.prekini();
        listaKorisnika.remove(okznit);
        forma.promeni(listaKorisnika);
        
    }
    public void postaviFormu(FrmServer f){
    forma=f;
    }
    public ServerskiOdgovor nadjiServisneListove(ServisniList servisniList){
        oso= new NadjiServisneListove();
         try {
            oso.opsteIzvrsenjeSO(servisniList);
            odgovor = new ServerskiOdgovor(((NadjiServisneListove) oso).getLista(), "Sistem je nasao servisne listove.",null);    
        } 
         catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da nadje servisne listove.",ex);
        }
        return odgovor;
    }

    public ServerskiOdgovor vratiListuAutomobila(Automobil automobil) {
        oso = new VratiListuAutomobila();
        try {
            oso.opsteIzvrsenjeSO(automobil);
            odgovor = new ServerskiOdgovor(((VratiListuAutomobila) oso).getLista(), "Sistem je nasao automobile",null); 
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            odgovor= new ServerskiOdgovor(null,"Sistem ne moze da nadje automobile",ex);
        }
        return odgovor;
    }
}
