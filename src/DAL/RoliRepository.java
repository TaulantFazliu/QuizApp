package DAL;

import BLL.Roli;
import java.util.List;


public class RoliRepository extends EntMngClass implements RoliInterface {

    @Override
    public void create(Roli fm) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.persist(fm);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Roli fm) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(fm);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Roli fm) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(fm);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Roli> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Roli.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Roli findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet"); 
    }
    
}
