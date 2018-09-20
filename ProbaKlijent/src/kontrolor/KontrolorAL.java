/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolor;

/**
 *
 * @author Korisnik
 */
public class KontrolorAL {
    private static KontrolorAL instance;
    private KontrolorAL() {
    }
    public static KontrolorAL getInstance(){
    if(instance==null){
    instance= new KontrolorAL();
    }
    return instance;
    }
    
}
