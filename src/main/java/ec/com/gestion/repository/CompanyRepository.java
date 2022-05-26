package ec.com.gestion.repository;

import ec.com.gestion.entity.CompanyEntity;
import ec.com.gestion.vo.CompanyVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QCompanyEntity.companyEntity;
/**
 * Class to implements company repository interface.
 */
@Lazy
@Repository
public class CompanyRepository extends QueryDslRepository<CompanyEntity> implements ICompanyRepository {

    public CompanyRepository() { super(CompanyEntity.class); }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<CompanyVO> findAll(){
        return from(companyEntity).select(bean(CompanyVO.class,
                companyEntity.companyId,
                companyEntity.name,
                companyEntity.address,
                companyEntity.phoneNumber))
                .where(companyEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompanyVO findByCompanyId(Long id) {
        return from(companyEntity).select(bean(CompanyVO.class,
                companyEntity.companyId,
                companyEntity.name,
                companyEntity.address,
                companyEntity.phoneNumber))
                .where(companyEntity.companyId.eq(id)).fetchOne();
    }
}
