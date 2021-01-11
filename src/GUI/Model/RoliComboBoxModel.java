package GUI.Model;

import BLL.Roli;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class RoliComboBoxModel extends AbstractListModel<Roli> implements ComboBoxModel<Roli> {

    private List<Roli> data;
    private Roli selectedItem;
    
    public RoliComboBoxModel(){}
    
    public RoliComboBoxModel(List<Roli> data){
        this.data = data;
    }
    
    public void add(List<Roli> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Roli getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Roli)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
