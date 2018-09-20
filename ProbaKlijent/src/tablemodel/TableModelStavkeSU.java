/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;


import domen.StavkaServisnogLista;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelStavkeSU extends AbstractTableModel {
     private ArrayList<StavkaServisnogLista>lista;

    public TableModelStavkeSU() {
        lista= new ArrayList<>();
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
       
        StavkaServisnogLista stavka = lista.get(rowIndex);
        switch(columnIndex){
                   case 0 : return stavka.getRedniBrojStavke();
                   case 1 : return stavka.getServisnaUsluga().getNazivServisneUsluge();
                   default: return "n/a";
               }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Redni broj";
            case 1: return "Naziv servisne usluge";
            default: return "n/a";
        }
    
    }

    public void setLista(ArrayList<StavkaServisnogLista> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public ArrayList<StavkaServisnogLista> getLista() {
        return lista;
    }
    
}
