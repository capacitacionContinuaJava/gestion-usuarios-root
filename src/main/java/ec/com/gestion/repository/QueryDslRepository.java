package ec.com.gestion.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.io.Serializable;
import java.util.Collection;

public abstract class QueryDslRepository<T> extends QuerydslRepositorySupport implements IQueryDslRepository<T> {

    private final Class<T> domainClass;

    /**
     * Construct class.
     * @param domainClass
     */
    public QueryDslRepository(Class<T> domainClass) {
        super(domainClass);
        this.domainClass = domainClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(T obj) {
        getEntityManager().persist(obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveAll(Collection<T> objs) {
        objs.forEach(obj -> getEntityManager().persist(obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T obj) {
        getEntityManager().merge(obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(Serializable id) {
        return getEntityManager().find(domainClass, id);
    }
}
