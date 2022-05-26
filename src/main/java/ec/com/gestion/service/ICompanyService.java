package ec.com.gestion.service;

import ec.com.gestion.vo.CompanyVO;

import java.util.List;

/**
 * Interface to management company service methods.
 */
public interface ICompanyService {

    /**
     * Method to find company list
     * @return
     */
    List<CompanyVO> findAll();

    /**
     * Method to find company by id.
     * @param id
     * @return
     */
    CompanyVO findByCompanyId(Long id);

    /**
     * Method to create company.
     * @param companyVO
     */
    void createCompany(CompanyVO companyVO);

}
