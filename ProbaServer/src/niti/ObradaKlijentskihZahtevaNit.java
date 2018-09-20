/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Automobil;
import domen.Klijent;
import domen.Korisnik;
import domen.ServisnaUsluga;
import domen.ServisniList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnalogika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class ObradaKlijentskihZahtevaNit extends Thread{
    Socket s;
    private Korisnik korisnik;
    private Date vremePrijave;
    boolean kraj=false;
    public ObradaKlijentskihZahtevaNit(Socket s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        while(!isInterrupted()){
            KlijentskiZahtev klijentskiZahtev= primiZahtev();
            ServerskiOdgovor serverskiOdgovor= new ServerskiOdgovor();
            switch(klijentskiZahtev.getOperacija()){
                case operacije.Operacija.ZAPAMTI_KLIJENTA: {
                Klijent klijent= (Klijent) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().zapamtiKlijenta(klijent);
                break; 
            }
                case operacije.Operacija.IZMENI_KLIJENTA: {
                Klijent klijent= (Klijent) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().izmeniKlijenta(klijent);
                break; 
            }
                case operacije.Operacija.OBRISI_KLIJENTA: {
                Klijent klijent= (Klijent) klijentskiZahtev.getParametar();    
                serverskiOdgovor= Kontroler.getInstance().obrisiKlijenta(klijent);
                break; 
            }
                case operacije.Operacija.VRATI_LISTU_KLIJENATA: {
                serverskiOdgovor=Kontroler.getInstance().vratiListuKlijenata();
                break; 
            }
                case operacije.Operacija.NADJI_KLIJENTA: {
                Klijent klijent=(Klijent) klijentskiZahtev.getParametar();
                serverskiOdgovor=Kontroler.getInstance().nadjiKlijenta(klijent);
                break; 
            }
                case operacije.Operacija.VRATI_LISTU_VRSTA_SERVISNIH_USLUGA: {
                serverskiOdgovor=Kontroler.getInstance().vratiListuVrstaServisnihUsluga();
                break; 
            }
                case operacije.Operacija.ZAPAMTI_SERVISNU_USLUGU: {
                ServisnaUsluga servisnaUsluga= (ServisnaUsluga) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().zapamtiServisnuUslugu(servisnaUsluga);
                break; 
            }
                case operacije.Operacija.IZMENI_SERVISNU_USLUGU: {
                ServisnaUsluga servisnaUsluga= (ServisnaUsluga) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().izmeniServisnuUslugu(servisnaUsluga);
                break; 
            }
                case operacije.Operacija.NADJI_SERVISNE_USLUGE_IZ_VRSTE: {
                ServisnaUsluga servisnaUsluga= (ServisnaUsluga) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().nadjiServisneUslugeIzVrste(servisnaUsluga);
                break; 
            }
                case operacije.Operacija.ZAPAMTI_SERVISNI_LIST: {
                ServisniList servisniList= (ServisniList) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().zapamtiServisniList(servisniList);
                break; 
            }
                case operacije.Operacija.LOGOVANJE: {
                Korisnik kor=(Korisnik) klijentskiZahtev.getParametar();
                serverskiOdgovor=Kontroler.getInstance().logovanje(kor);
                if(serverskiOdgovor.getIzuzetak()==null){
                korisnik=(Korisnik) serverskiOdgovor.getParametar();
                vremePrijave=new Date();
                Kontroler.getInstance().registrujKorisnika(this);
                }
                break; 
            }
                case operacije.Operacija.LOGOUT: {
                Kontroler.getInstance().izlogujSe(this);
                break; 
            }
                case operacije.Operacija.NADJI_SERVISNE_LISTOVE: {
                ServisniList servisniList= (ServisniList) klijentskiZahtev.getParametar();
                serverskiOdgovor= Kontroler.getInstance().nadjiServisneListove(servisniList);
                break; 
            }
                case operacije.Operacija.VRATI_LISTU_AUTOMOBILA: {
                Automobil automobil=(Automobil) klijentskiZahtev.getParametar();
                serverskiOdgovor=Kontroler.getInstance().vratiListuAutomobila(automobil);
                break; 
            }
                
        }
            if (kraj) {
            serverskiOdgovor = new ServerskiOdgovor();
            serverskiOdgovor.setPoruka("Logout");
            System.out.println("doslo ovde");
            this.interrupt();
        }
            posaljiOdgovor(serverskiOdgovor);
    }
    }
    public KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev zahtev= new KlijentskiZahtev();
        try {
           
           ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            zahtev =(KlijentskiZahtev) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return zahtev;
    }

    public void posaljiOdgovor(ServerskiOdgovor serverskiOdgovor) {
        
        try {
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(serverskiOdgovor);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
       
        }}

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Date getVremePrijave() {
        return vremePrijave;
    }

    public void setVremePrijave(Date vremePrijave) {
        this.vremePrijave = vremePrijave;
    }
   public void prekini() {
        kraj = true;

    }
}
