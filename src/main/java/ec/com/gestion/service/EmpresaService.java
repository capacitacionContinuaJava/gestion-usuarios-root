package ec.com.gestion.service;

import ec.com.gestion.entity.EmpresaEntity;
import ec.com.gestion.repository.IEmpresaRepository;
import ec.com.gestion.vo.EmpresaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implements empresa service interfaces methods.
 */
@Lazy
@Transactional
@Service
public class EmpresaService implements IEmpresaService {

    @Autowired
    private IEmpresaRepository empresaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmpresaVO> findAll() {
        return this.empresaRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmpresaVO findByEmpresaId(Long id) {
        return this.empresaRepository.findByEmpresaId(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createEmpresa(EmpresaVO empresaVO) {
        EmpresaEntity empresaEntity = EmpresaEntity.builder()
                .empresaId(empresaVO.getEmpresaId())
                .empresaName(empresaVO.getEmpresaName())
                .status(empresaVO.getStatus())
                .createEmpresaId(empresaVO.getCreateEmpresaId())
                .createdDate(new Date())
                .build();
        if (empresaEntity.getEmpresaId() == null){
            this.empresaRepository.save(empresaEntity);
        }else {
            empresaEntity.setModifiedEmpresaId(empresaVO.getModifiedEmpresaId());
            empresaEntity.setModifiedDate(new Date());
            this.empresaRepository.update(empresaEntity);
        }
    }
}

