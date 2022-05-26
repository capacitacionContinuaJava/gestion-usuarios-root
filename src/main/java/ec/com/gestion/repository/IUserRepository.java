package ec.com.gestion.repository;

import ec.com.gestion.entity.UserEntity;
import ec.com.gestion.vo.UserVO;

import java.util.List;

/**
 * Interface to management user repository.
 */
public interface IUserRepository extends IQueryDslRepository<UserEntity> {

    /**
     * Method to find user list.
     */
    List<UserVO> findAll();

    /**
     * Find user by id.
     * @param id
     * @return
     */
    UserVO findByUserId(Long id);

    /**
     * Find user by user name.
     * @param userName
     * @return
     */
    UserVO findByUserName(String userName);

}
