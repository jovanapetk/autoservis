/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.FrmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class ServerNit extends Thread{
     FrmServer frm;

    public ServerNit(FrmServer frm) {
        this.frm = frm;
    }
     @Override
    public void run() {
         try {
                ServerSocket ss= new ServerSocket(9000);
                System.out.println("pokrenut");
                frm.serverPokrenut();
                ZaustaviNit zn= new ZaustaviNit(this, ss);
                zn.start();
                while(!isInterrupted()){
                    Socket s= ss.accept();
                    System.out.println("klijent prikacen");
                    ObradaKlijentskihZahtevaNit ozn= new ObradaKlijentskihZahtevaNit(s);
                    
                    ozn.start();
                }
            } catch (IOException ex) {
                frm.serverZaustavljen();
               
            }
        
    }
}
