package DAL;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class EntMngClass {
    EntityManager em = Persistence.createEntityManagerFactory("QuizAppPU").createEntityManager();
}
