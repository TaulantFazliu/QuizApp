package GUI.Model;

import BLL.Perdoruesi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PerdoruesiTableModel extends AbstractTableModel {
    
    List <Perdoruesi> list;
        String [] cols = {"PerdoruesiID", "Username" , "Password", "RoliID"};
    
    public PerdoruesiTableModel(){}
    
    public PerdoruesiTableModel(List<Perdoruesi> list){
        this.list = list;
    }
    
    public void addList(List<Perdoruesi> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int col){
        return cols[col];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    public void remove(int row){
        list.remove(row);
    }
    
    public Perdoruesi getPerdoruesi(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perdoruesi fm = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return fm.getId(); 
            case 1:
                return fm.getUsername();
            case 2:
                return fm.getPassword();
            case 3:
                return fm.getRoliID();
            default:
                return null;
        }
    }
    
  
    
}
