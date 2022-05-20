package ec.com.gestion.service;

import ec.com.gestion.entity.CompanyEntity;
import ec.com.gestion.repository.ICompanyRepository;
import ec.com.gestion.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implements company service interfaces methods.
 */
@Lazy
@Transactional
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CompanyVO> findAll() {
        return this.companyRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyVO findByCompanyId(Long id) {
        return this.companyRepository.findByCompanyId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createCompany(CompanyVO companyVO) {
        CompanyEntity companyEntity = CompanyEntity.builder()
                .companyId(companyVO.getCompanyId())
                .name(companyVO.getName())
                .address(companyVO.getAddress())
                .phoneNumber(companyVO.getPhoneNumber())
                .status(companyVO.getStatus())
                .createUserId(companyVO.getCreateUserId())
                .createdDate(new Date())
                .build();
        if (companyEntity.getCompanyId() == null){
            this.companyRepository.save(companyEntity);
        }else {
            companyEntity.setModifiedUserId(companyVO.getModifiedUserId());
            companyEntity.setModifiedDate(new Date());
            this.companyRepository.update(companyEntity);
        }
    }
}

