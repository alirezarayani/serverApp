package ir.lazydeveloper.serverapp.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    @PersistenceContext
    private EntityManager entityManager;

    public List getByProgrammingLID(int pLID) {
        return this.entityManager
                .createQuery("SELECT Q FROM Question Q INNER JOIN ProgrammingLanguage PL ON PL.id = Q.language.id WHERE PL.id =: plID ")
                .setParameter("plID", pLID)
                .getResultList();
    }

}
