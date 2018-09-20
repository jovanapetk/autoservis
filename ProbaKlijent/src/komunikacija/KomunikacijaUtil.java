/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Korisnik
 */
public class KomunikacijaUtil {
     Properties props;

    public KomunikacijaUtil() throws IOException {
        props= new Properties();
        props.load(new FileInputStream("konekcijaproperties.properties"));
    }
    
     public String vratiIP(){
         return props.getProperty(KomunikacijaKonstante.IP);
     }
     
     public String vratiPort(){
         return props.getProperty(KomunikacijaKonstante.PORT);
     }
}
