/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import domen.ServisnaUsluga;
import domen.VrstaServisneUsluge;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelServisneUsluge extends AbstractTableModel{
    ArrayList<ServisnaUsluga>lista;

    public TableModelServisneUsluge(ArrayList<ServisnaUsluga> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        ServisnaUsluga su= lista.get(rowIndex);
        switch(columnIndex){
                   case 0 : return su.getNazivServisneUsluge();
                   case 1 : return su.getVremeTrajanja();
                   case 2 : return su.getCena();
                   default: return "n/a";
               }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Servisna usluga";
            case 1: return "Vreme trajanja(sat)";
            case 2: return "Cena";
            default: return "n/a";
        }
    
    }

    public ServisnaUsluga vratiServisnuUslugu(int index) {
        return lista.get(index);
    }

    public void izmeni(int index, ServisnaUsluga su) {
        ServisnaUsluga servisnaUsluga= lista.get(index);
        servisnaUsluga.setCena(su.getCena());
        servisnaUsluga.setVremeTrajanja(su.getVremeTrajanja());
        fireTableDataChanged();
    }
    public void ubaciUListu(ServisnaUsluga su){
    lista.add(su);
    fireTableDataChanged();
    }
    public ArrayList<ServisnaUsluga> vratilistu(){
    return lista;
    }
}
