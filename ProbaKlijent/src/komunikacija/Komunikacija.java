/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Korisnik
 */
public class Komunikacija {
     private static Komunikacija instance;
    Socket s;
    private Komunikacija() {
        povezivanje();
    }
    public static Komunikacija getInstance(){
    if(instance==null){
    instance= new Komunikacija();
    }
    return instance;
    }
    
    public void posaljiZahtev(KlijentskiZahtev zahtev){
        
       
        try {
           ObjectOutputStream   outKaServ = new ObjectOutputStream(s.getOutputStream());
           outKaServ.writeObject(zahtev);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
       
        }
        
    }
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        
        try {
           
          ObjectInputStream  inOdServera = new ObjectInputStream(s.getInputStream());
            odgovor=(ServerskiOdgovor) inOdServera.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return odgovor;
    }

    public void povezivanje() {
        try {
            KomunikacijaUtil ku = new KomunikacijaUtil();
            String localhost = ku.vratiIP();
            int port = Integer.parseInt(ku.vratiPort());
            s = new Socket(localhost, port);
            System.out.println("Klijent se povezao na server");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Greška u povezivanju sa serverom. Ponovo pokrenite program.", "GREŠKA", JOptionPane.ERROR_MESSAGE);
           
        }
    }
}
