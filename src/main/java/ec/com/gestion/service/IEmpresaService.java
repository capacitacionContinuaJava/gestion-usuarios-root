package ec.com.gestion.service;

import ec.com.gestion.vo.EmpresaVO;

import java.util.List;

/**
 * Interface to management empresa service methods.
 */
public interface IEmpresaService {

    /**
     * Method to find empresa list
     * @return
     */
    List<EmpresaVO> findAll();

    /**
     * Method to find empresa by id.
     * @param id
     * @return
     */
    EmpresaVO findByEmpresaId(Long id);

    /**
     * Method to create empresa.
     * @param empresaVO
     */
    void createEmpresa(EmpresaVO empresaVO);

}
