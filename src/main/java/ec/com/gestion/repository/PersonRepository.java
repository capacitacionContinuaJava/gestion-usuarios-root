package ec.com.gestion.repository;


import ec.com.gestion.entity.PersonEntity;
import ec.com.gestion.vo.PersonVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QPersonEntity.personEntity;
import static ec.com.gestion.entity.QUserEntity.userEntity;

/**
 * Class to implement person repository interface.
 */
@Lazy
@Repository
public class PersonRepository extends QueryDslRepository<PersonEntity> implements IPersonRepository {

    public PersonRepository(){
        super(PersonEntity.class);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<PersonVO> findAll() {
        return from(personEntity).select(bean(PersonVO.class,
                personEntity.personId,
                personEntity.documentNumber,
                personEntity.firstName,
                personEntity.lastName))
                .where(personEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonVO findByPersonId(Long id) {
        return from(personEntity).select(bean(PersonVO.class,
                personEntity.personId,
                personEntity.documentNumber,
                personEntity.firstName,
                personEntity.lastName))
                .where(userEntity.userId.eq(id)).fetchOne();
    }

}
