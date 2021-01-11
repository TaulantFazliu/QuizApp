package DAL;

import BLL.Roli;
import java.util.List;

public interface RoliInterface {
    void create(Roli fm) throws CrudFormException;
    void edit(Roli fm) throws CrudFormException;
    void delete(Roli fm) throws CrudFormException;
    List<Roli> findAll() throws CrudFormException;
    Roli findByID(Integer ID) throws CrudFormException;
}
