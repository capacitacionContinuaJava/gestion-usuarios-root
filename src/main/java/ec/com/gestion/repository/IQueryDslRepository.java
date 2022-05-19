package ec.com.gestion.repository;

import java.io.Serializable;
import java.util.Collection;

public interface IQueryDslRepository<T> {

    /**
     * Save object T.
     * @param obj
     */
    void save(T obj);

    /**
     * Save list objects T.
     * @param objs
     */
    void saveAll(Collection<T> objs);

    /**
     * Update object T.
     * @param obj
     */
    void update(T obj);

    /**
     * Find by id.
     * @param id
     * @return
     */
    T findById(Serializable id);
}
