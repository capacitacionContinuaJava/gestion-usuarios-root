package ec.com.gestion.repository;


import ec.com.gestion.entity.UserEntity;
import ec.com.gestion.vo.UserVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QUserEntity.userEntity;

/**
 * Class to implement user repository interface.
 */
@Lazy
@Repository
public class UserRepository extends QueryDslRepository<UserEntity> implements IUserRepository {

    public UserRepository(){
        super(UserEntity.class);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<UserVO> findAll() {
        return from(userEntity).select(bean(UserVO.class,
                userEntity.userId,
                userEntity.userName))
                .where(userEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO findByUserId(Long id) {
        return from(userEntity).select(bean(UserVO.class,
                userEntity.userId.as("userId"),
                userEntity.userName.as("userName")))
                .where(userEntity.userId.eq(id)).fetchOne();
    }

}
