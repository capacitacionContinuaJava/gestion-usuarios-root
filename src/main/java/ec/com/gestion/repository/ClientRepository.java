package ec.com.gestion.repository;

import ec.com.gestion.entity.ClientEntity;
import ec.com.gestion.vo.ClientVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QClientEntity.clientEntity;

/**
 * Class to implement client repository interface.
 */
@Lazy
@Repository
public class ClientRepository extends QueryDslRepository<ClientEntity> implements IClientRepository{

    public ClientRepository() { super(ClientEntity.class);}

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<ClientVO> findAll(){
        return from(clientEntity).select(bean(ClientVO.class,
                clientEntity.clientId))
                .where(clientEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientVO findByClientId(Long id) {
        return from(clientEntity).select(bean(ClientVO.class,
                        clientEntity.clientId.as("clientId")))
                .where(clientEntity.clientId.eq(id)).fetchOne();
    }
}
