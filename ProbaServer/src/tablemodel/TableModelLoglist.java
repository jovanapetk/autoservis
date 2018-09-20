/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import niti.ObradaKlijentskihZahtevaNit;

/**
 *
 * @author Korisnik
 */
public class TableModelLoglist extends AbstractTableModel{
private ArrayList<ObradaKlijentskihZahtevaNit> lista;

    public TableModelLoglist() {
        lista = new ArrayList<ObradaKlijentskihZahtevaNit>();
    }

    public TableModelLoglist(ArrayList<ObradaKlijentskihZahtevaNit> lista) {
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
        if (columnIndex == 0) {
            return lista.get(rowIndex).getKorisnik().getUsername();
        }
        if (columnIndex == 1) {
            return lista.get(rowIndex).getVremePrijave();
        }

        return null;
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "user";
            case 1: return "vreme";
            default: return "n/a";
        }
    
    }

    public ArrayList<ObradaKlijentskihZahtevaNit> getLista() {
        return lista;
    }
    public void dodaj(ObradaKlijentskihZahtevaNit kl){ //bez ovoga
        lista.add(kl);
        fireTableDataChanged();
    }
    
    public void ukolni(ObradaKlijentskihZahtevaNit kl){  //bez ovoga
        lista.remove(kl);
        fireTableDataChanged();
    }

    public void setLista(ArrayList<ObradaKlijentskihZahtevaNit> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    
}
