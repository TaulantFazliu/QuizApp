package GUI.Model;

import BLL.Roli;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RoliTableModel extends AbstractTableModel {
    
    List <Roli> list;
        String [] cols = {"RoliID","Emertimi"};
    
    public RoliTableModel(){}
    
    public RoliTableModel(List<Roli> list){
        this.list = list;
    }
    
    public void addList(List<Roli> list){
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
    
    public Roli getRoli(int index){
        return list.get(index);
    }

    @Override
    public int getColumnCount() {
       return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Roli p = list.get(rowIndex);
        switch(columnIndex){
            case 0:
                return p.getId();
            case 1:
                return p.getEmertimi();
            default:
                return null;
        }
    }
    
//    public String getDateToString(Date d){
//        DateFormat da = new SimpleDateFormat("dd-MM-yyyy");
//        return da.format(d);
//    }
    
}
