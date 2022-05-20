package ec.com.gestion.service;

import ec.com.gestion.entity.UserEntity;
import ec.com.gestion.repository.IUserRepository;
import ec.com.gestion.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implement user service interface methods.
 */
@Lazy
@Transactional
@Service
public class UserService implements  IUserService {

    @Autowired
    private IUserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserVO> findAll() {
        return this.userRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO findByUserId(Long id) {
        return this.userRepository.findByUserId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserVO findByUserName(String userName) {
        return  this.userRepository.findByUserName(userName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createUser(UserVO userVO) {
        UserEntity userEntity = UserEntity.builder()
                .userId(userVO.getUserId())
                .personId(userVO.getPersonId())
                .companyId(userVO.getCompanyId())
                .userName(userVO.getUserName())
                .status(userVO.getStatus())
                .createUserId(userVO.getCreateUserId())
                .createdDate(new Date())
                .build();
        if(userEntity.getUserId() == null){
            this.userRepository.save(userEntity);
        }else{
            userEntity.setModifiedUserId(userVO.getModifiedUserId());
            userEntity.setModifiedDate(new Date());
            this.userRepository.update(userEntity);
        }
    }
}
