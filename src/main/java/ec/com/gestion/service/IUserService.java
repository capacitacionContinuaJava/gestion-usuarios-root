package ec.com.gestion.service;

import ec.com.gestion.vo.UserVO;

import java.util.List;

/**
 * Interface to management user service methods.
 */
public interface IUserService {

    /**
     * Method to find user list.
     * @return
     */
    List<UserVO> findAll();

    /**
     * Method to find user by id.
     * @param id
     * @return
     */
    UserVO findByUserId(Long  id);

    /**
     * Method to create user.
     * @param userVO
     */
    void createUser(UserVO userVO);
}
