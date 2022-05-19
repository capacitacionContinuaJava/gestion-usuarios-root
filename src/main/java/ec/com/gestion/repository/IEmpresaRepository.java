package ec.com.gestion.repository;

import ec.com.gestion.entity.EmpresaEntity;
import ec.com.gestion.vo.EmpresaVO;

import java.util.List;

/**
 * Interface to management user repository.
 */
public interface IEmpresaRepository extends IQueryDslRepository<EmpresaEntity> {

    /**
     * Method to find empresa list.
     */
    List<EmpresaVO> findAll();

    /**
     * Find empresa by id.
     * @param id
     * @return
     */
    EmpresaVO findByEmpresaId(Long id);
}
