package ec.com.gestion.service;

import ec.com.gestion.vo.EmployeeVO;

import java.util.List;

/**
 * Interface to management employee service methods.
 */
public interface IEmployeeService {

    /**
     * Method to find employee list.
     * @return
     */
    List<EmployeeVO> findAll();

    /**
     * Method to find employee by id.
     * @param id
     * @return
     */
    EmployeeVO findByEmployeeId(Long id);

    /**
     * Method to create employee.
     * @param employeeVO
     */
    void createEmployee(EmployeeVO employeeVO);

}
