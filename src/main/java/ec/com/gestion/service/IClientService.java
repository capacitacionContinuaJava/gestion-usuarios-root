package ec.com.gestion.service;

import ec.com.gestion.vo.ClientVO;

import java.util.List;

/**
 * Interface to management client service methods.
 */
public interface IClientService {
    /**
     * Method to find client list.
     * @return
     */

    List<ClientVO> findAll();

    /**
     * Method to find user by id.
     * @param id
     * @return
     */

    ClientVO findByClientId(Long id);

    /**
     * Method to create cient.
     * @param clientVO
     */
    
    void createClient(ClientVO clientVO);

}
