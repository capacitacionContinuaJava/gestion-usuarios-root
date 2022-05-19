package ec.com.gestion.repository;

import ec.com.gestion.entity.ClientEntity;
import ec.com.gestion.vo.ClientVO;

import java.util.List;

/**
 * Interface to management client repository.
 */
public interface IClientRepository extends IQueryDslRepository<ClientEntity> {

    /**
     * Method to find client list.
     */

    List<ClientVO> findAll();

    /**
     * Find user by id.
     * @param id
     * @return
     */

    ClientVO findByClientId(Long id);
}
