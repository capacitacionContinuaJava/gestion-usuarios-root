package ec.com.gestion.service;

import ec.com.gestion.entity.ClientEntity;
import ec.com.gestion.repository.IClientRepository;
import ec.com.gestion.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implement client services interface methods.
 */
@Lazy
@Transactional
@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ClientVO> findAll() {
        return this.clientRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public ClientVO findByClientId(Long id){
        return this.clientRepository.findByClientId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createClient(ClientVO clientVO){
        ClientEntity clientEntity = ClientEntity.builder()
                .clientId(clientVO.getClientId())
                .status(clientVO.getStatus())
                .createClientId(clientVO.getCreateClientId())
                .createdDate(new Date())
                .build();
        if (clientEntity.getClientId() == null){
            this.clientRepository.save(clientEntity);
        }else {
            clientEntity.setModifiedClientId(clientVO.getModifiedClientId());
            clientEntity.setModifiedDate(new Date());
            this.clientRepository.update(clientEntity);
        }
    }

}
