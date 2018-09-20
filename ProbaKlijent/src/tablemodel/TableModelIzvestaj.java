/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelIzvestaj extends AbstractTableModel{
    ArrayList<Integer>listagodina;
    ArrayList<Double>listaprofita;

    public TableModelIzvestaj(ArrayList<Integer> listagodina, ArrayList<Double> listaprofita) {
        this.listagodina = listagodina;
        this.listaprofita = listaprofita;
    }

    

    public TableModelIzvestaj() {
    }
    
    
    @Override
    public int getRowCount() {
        return listagodina.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0){
        return listagodina.get(rowIndex);
        }if(columnIndex==1){
        return listaprofita.get(rowIndex);
        }else return"n/a";
    }
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Godina";
            case 1: return "Profit";
           
            default: return "n/a";
        }
    
    }
}
