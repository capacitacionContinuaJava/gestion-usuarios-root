package ec.com.gestion.repository;

import ec.com.gestion.entity.EmployeeEntity;
import ec.com.gestion.vo.EmployeeVO;

import java.util.List;

/**
 * Interface to management employee repository.
 */
public interface IEmployeeRepository extends IQueryDslRepository<EmployeeEntity> {

    /**
     * Method to find employee list.
     */
    List<EmployeeVO> findAll();

    /**
     * Find employee by id.
     * @param id
     * @return
     */
    EmployeeVO findByEmployeeId(Long id);

}
