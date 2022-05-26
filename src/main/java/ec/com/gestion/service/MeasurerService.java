
package ec.com.gestion.service;

import ec.com.gestion.entity.MeasurerEntity;
import ec.com.gestion.repository.IMeasurerRepository;
import ec.com.gestion.vo.MeasurerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Class to implements measurer service interfaces methods.
 */
@Lazy
@Transactional
@Service
public class MeasurerService implements IMeasurerService {

    @Autowired
    private IMeasurerRepository measurerRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MeasurerVO> findAll() {
        return this.measurerRepository.findAll();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public MeasurerVO findByMeasurerId (Long id){
        return this.measurerRepository.findByMeasurerId(id);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void createMeasurer (MeasurerVO measurerVO){
        MeasurerEntity measurerEntity = MeasurerEntity.builder()
                .measurerId(measurerVO.getMeasurerId())
                .measurermeterm3(measurerVO.getMeasurermeterm3())
                .status(measurerVO.getStatus())
                .createUserId(measurerVO.getCreateUserId())
                .createdDate(new Date())
                .build();
        if (measurerEntity.getMeasurerId() == null){
            this.measurerRepository.save(measurerEntity);
        }else {
            measurerEntity.setModifiedUserId(measurerVO.getModifiedUserId());
            measurerEntity.setModifiedDate(new Date());
            this.measurerRepository.update(measurerEntity);
        }
    }
}