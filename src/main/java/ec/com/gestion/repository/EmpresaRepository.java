package ec.com.gestion.repository;

import ec.com.gestion.entity.EmpresaEntity;
import ec.com.gestion.vo.EmpresaVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QEmpresaEntity.empresaEntity;
/**
 * Class to implements empresa repository interface.
 */
@Lazy
@Repository
public class EmpresaRepository extends QueryDslRepository<EmpresaEntity> implements IEmpresaRepository {

    public EmpresaRepository() { super(EmpresaEntity.class); }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<EmpresaVO> findAll(){
        return from(empresaEntity).select(bean(EmpresaVO.class,
                empresaEntity.empresaId,
                empresaEntity.empresaName))
                .where(empresaEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmpresaVO findByEmpresaId(Long id) {
        return from(empresaEntity).select(bean(EmpresaVO.class,
                empresaEntity.empresaId.as("empresaId"),
                empresaEntity.empresaName.as("empresaName")))
                .where(empresaEntity.empresaId.eq(id)).fetchOne();
    }
}
