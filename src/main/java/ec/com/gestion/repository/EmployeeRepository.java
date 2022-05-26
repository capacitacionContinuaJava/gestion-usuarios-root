package ec.com.gestion.repository;


import ec.com.gestion.entity.EmployeeEntity;
import ec.com.gestion.vo.EmployeeVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QEmployeeEntity.employeeEntity;

/**
 * Class to implement person repository interface.
 */
@Lazy
@Repository
public class EmployeeRepository extends QueryDslRepository<EmployeeEntity> implements IEmployeeRepository {

    public EmployeeRepository(){
        super(EmployeeEntity.class);
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<EmployeeVO> findAll() {
        return from(employeeEntity).select(bean(EmployeeVO.class,
                employeeEntity.employeeId,
                employeeEntity.personId,
                employeeEntity.companyId))
                .where(employeeEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeVO findByEmployeeId(Long id) {
        return from(employeeEntity).select(bean(EmployeeVO.class,
                employeeEntity.employeeId,
                employeeEntity.personId,
                employeeEntity.companyId))
                .where(employeeEntity.employeeId.eq(id)).fetchOne();
    }

}
