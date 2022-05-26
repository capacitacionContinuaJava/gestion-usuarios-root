package ec.com.gestion.repository;

import ec.com.gestion.entity.CompanyEntity;
import ec.com.gestion.vo.CompanyVO;

import java.util.List;

/**
 * Interface to management user repository.
 */
public interface ICompanyRepository extends IQueryDslRepository<CompanyEntity> {

    /**
     * Method to find company list.
     */
    List<CompanyVO> findAll();

    /**
     * Find company by id.
     * @param id
     * @return
     */
    CompanyVO findByCompanyId(Long id);
}
