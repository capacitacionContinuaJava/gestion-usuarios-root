package ec.com.gestion.service;

import ec.com.gestion.vo.PersonVO;

import java.util.List;

/**
 * Interface to management person service methods.
 */
public interface IPersonService {

    /**
     * Method to find person list.
     * @return
     */
    List<PersonVO> findAll();

    /**
     * Method to find person by id.
     * @param id
     * @return
     */
    PersonVO findByPersonId(Long id);

    /**
     * Method to create person.
     * @param personVO
     */
    void createPerson(PersonVO personVO);

}
