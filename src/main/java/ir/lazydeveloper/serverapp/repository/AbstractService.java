package ir.lazydeveloper.serverapp.repository;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository("dao")
@Transactional
public abstract class AbstractService<T> extends Parameterized<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Session getSession() {
        return this.getEntityManager().unwrap(Session.class);
    }

    public void saveOrUpdate(T entity) {
        this.getSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    public T byId(Integer id) {
        return this.byId(id, this.getClazz());
    }

    public T byId(Integer id, Class<T> clazz) {
        IdentifierLoadAccess<T> identifierLoadAccess = this.getSession().byId(clazz);
        return identifierLoadAccess.load(id);
    }

    public T get(Serializable id) {
        return this.get(id, this.getClazz());
    }

    public T get(Serializable id, Class<T> clazz) {
        return this.getSession().get(clazz, id);
    }

    public T find(Serializable id) {
        return this.find(id, this.getClazz());
    }

    public T find(Serializable id, Class<T> clazz) {
        return this.getSession().find(clazz, id);
    }

    public T load(Serializable id) {
        return this.load(id, this.getClazz());
    }

    public T load(Serializable id, Class<T> clazz) {
        return this.getSession().load(clazz, id);
    }

    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.getClazz());
        Root<T> rootQuery = criteriaQuery.from(this.getClazz());
        criteriaQuery.select(rootQuery);
        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
