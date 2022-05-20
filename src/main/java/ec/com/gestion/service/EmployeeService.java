package ec.com.gestion.service;

import ec.com.gestion.entity.EmployeeEntity;
import ec.com.gestion.repository.IEmployeeRepository;
import ec.com.gestion.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implement employee service interface methods.
 */
@Lazy
@Transactional
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeVO> findAll() {
        return this.employeeRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeVO findByEmployeeId(Long id) {
        return this.employeeRepository.findByEmployeeId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createEmployee(EmployeeVO employeeVO) {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .employeeId(employeeVO.getEmployeeId())
                .personId(employeeVO.getPersonId())
                .companyId(employeeVO.getCompanyId())
                .status(employeeVO.getStatus())
                .createUserId(employeeVO.getCreateUserId())
                .createdDate(new Date())
                .build();
        if(employeeEntity.getEmployeeId() == null){
            this.employeeRepository.save(employeeEntity);
        }else{
            employeeEntity.setModifiedUserId(employeeVO.getModifiedUserId());
            employeeEntity.setModifiedDate(new Date());
            this.employeeRepository.update(employeeEntity);
        }
    }
}
