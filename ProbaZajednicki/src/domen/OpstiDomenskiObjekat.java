/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat extends Serializable{
    public ArrayList<OpstiDomenskiObjekat> napuni(ResultSet rs) throws Exception; 
    
    
            
    public  void postavi(OpstiDomenskiObjekat odo);

    public  String vratiNazivTabele();

    public String vratiJoin();

    public String vratiWhere();

    public String vratiVrednostZaInsert();

    public String vratiVrednostZaUpdate();
    
    public String vratiVrednostZaPretragu();
    
    public String vratiID();
    
    public String vratiWhereZaKriterijume();
}
