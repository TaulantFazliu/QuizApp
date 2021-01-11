package DAL;

import BLL.Perdoruesi;
import java.util.List;
import javax.persistence.Query;

public class PerdoruesiRepository extends EntMngClass implements PerdoruesiInterface {

    @Override
    public void create(Perdoruesi p) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Perdoruesi p) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Perdoruesi p) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Perdoruesi> findAll() throws CrudFormException {
        try {
            return em.createNamedQuery("Perdoruesi.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi findByID(Integer ID) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Perdoruesi) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi loginByUsernameAndPassword(String u, String p) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.username = :us AND p.password=:psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Perdoruesi) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}
