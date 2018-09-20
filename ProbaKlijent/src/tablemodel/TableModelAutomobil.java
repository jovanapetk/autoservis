/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;


import domen.Automobil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelAutomobil extends AbstractTableModel{
    private ArrayList<Automobil>lista;

    public TableModelAutomobil(ArrayList<Automobil> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Automobil a= lista.get(rowIndex);
        switch(columnIndex){
                   case 0 : return a.getRegistarskiBroj();
                   case 1 : return a.getModel().getProizvodjac().getNazivProizvodjaca();
                   case 2 : return a.getModel().getNazivModela();
                   case 3 : return a.getKilometraza();
                   case 4 : return a.getGodiste();
                   default: return "n/a";
               }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Registarski broj";
            case 1: return "Marka";
            case 2: return "Model";
            case 3: return "Kilometraza";
            case 4: return "Godiste";
            default: return "n/a";
        }
    
    }

    public void setLista(ArrayList<Automobil> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }
    public Automobil getAuto(int i){
    return lista.get(i);
    }
}
