package ec.com.gestion.service;

import ec.com.gestion.entity.PersonEntity;
import ec.com.gestion.repository.IPersonRepository;
import ec.com.gestion.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implement person service interface methods.
 */
@Lazy
@Transactional
@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PersonVO> findAll() {
        return this.personRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonVO findByPersonId(Long id) {
        return this.personRepository.findByPersonId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createPerson(PersonVO personVO) {
        PersonEntity personEntity = PersonEntity.builder()
                .personId(personVO.getPersonId())
                .firstName(personVO.getFirstName())
                .lastName(personVO.getLastName())
                .documentNumber(personVO.getDocumentNumber())
                .documentType(personVO.getDocumentType())
                .status(personVO.getStatus())
                .createUserId(personVO.getCreateUserId())
                .createdDate(new Date())
                .build();
        if(personEntity.getPersonId() == null){
            this.personRepository.save(personEntity);
        }else{
            personEntity.setModifiedUserId(personVO.getModifiedUserId());
            personEntity.setModifiedDate(new Date());
            this.personRepository.update(personEntity);
        }
    }
}
