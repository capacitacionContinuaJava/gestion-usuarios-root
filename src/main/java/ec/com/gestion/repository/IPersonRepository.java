package ec.com.gestion.repository;

import ec.com.gestion.entity.PersonEntity;
import ec.com.gestion.vo.PersonVO;

import java.util.List;

/**
 * Interface to management person repository.
 */
public interface IPersonRepository extends IQueryDslRepository<PersonEntity> {

    /**
     * Method to find user list.
     */
    List<PersonVO> findAll();

    /**
     * Find user by id.
     * @param id
     * @return
     */
    PersonVO findByPersonId(Long id);

}
