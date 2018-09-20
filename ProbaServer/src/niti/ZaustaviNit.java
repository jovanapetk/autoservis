/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class ZaustaviNit extends Thread{
    ServerNit nit;
    ServerSocket ss;
    boolean kraj=false;
    public ZaustaviNit(ServerNit nit, ServerSocket ss) {
        this.nit = nit;
        this.ss = ss;
    }

    @Override
    public void run() {
       while(!kraj){
           if(nit.isInterrupted()){
               try {
                   ss.close();
                   kraj=true;
               } catch (IOException ex) {
                   Logger.getLogger(ZaustaviNit.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
           try {
               sleep(100);
           } catch (InterruptedException ex) {
               Logger.getLogger(ZaustaviNit.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
