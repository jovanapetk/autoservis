/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import domen.Klijent;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelKlijent extends AbstractTableModel{
    ArrayList<Klijent>lista;

    public TableModelKlijent(ArrayList<Klijent> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent k= lista.get(rowIndex);
        switch(columnIndex){
                   case 0 : return k.getIme();
                   case 1 : return k.getPrezime();
                   default: return "n/a";
               }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Ime";
            case 1: return "Prezime";
            default: return "n/a";
        }
    
    }
    
    public Klijent vratiKlijenta(int index) {
        return lista.get(index);
    }

    public void izmeniKlijenta(int index, Klijent izmenjen) {
       Klijent k=lista.get(index);
       k.setBrojZiroRacuna(izmenjen.getBrojZiroRacuna());
       fireTableDataChanged();
    }

    public Klijent obrisiKlijenta(int index) {
        Klijent k=lista.get(index);
        lista.remove(index);
        fireTableDataChanged();
        return k;
    }

    public void ubaciKlijenta(Klijent klijent) {
        lista.add(klijent);
        fireTableDataChanged();
    }
    
    
}