/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author Korisnik
 */
public class Pretvaranje {
    File file;
    List<JTable> listaTabela;
    List<String> brojsheetova;

    public Pretvaranje(File file, List<JTable> listaTabela, List<String> brojsheetova) throws Exception {
        this.file = file;
        this.listaTabela = listaTabela;
        this.brojsheetova = brojsheetova;
        if(brojsheetova.size()!=listaTabela.size()){
        throw new Exception("Greska");
        }
    }
    public boolean export(){
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            WritableWorkbook w= Workbook.createWorkbook(out);
            for (int index = 0; index < listaTabela.size(); index++) {
                JTable table=listaTabela.get(index);
                WritableSheet s= w.createSheet(brojsheetova.get(index), 0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object object=table.getValueAt(j, i);
                        s.addCell(new Label(i,j,String.valueOf(object)));
                    }
                    
                }
                
            }
            w.write();
            w.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
