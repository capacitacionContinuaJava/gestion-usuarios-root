package ec.com.gestion.repository;

import ec.com.gestion.entity.MeasurerEntity;
import ec.com.gestion.vo.MeasurerVO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static ec.com.gestion.entity.QMeasurerEntity.measurerEntity;

/**
 * Class to implement measurer repository interface.
 */
@Lazy
@Repository

public class MeasurerRepository extends QueryDslRepository<MeasurerEntity> implements IMeasurerRepository {

    public MeasurerRepository() { super(MeasurerEntity.class);}

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<MeasurerVO> findAll(){
        return from(measurerEntity).select(bean(MeasurerVO.class,
                        measurerEntity.measurerId))
                .where(measurerEntity.status.eq(Boolean.TRUE)).fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeasurerVO findByMeasurerId(Long id) {
        return from(measurerEntity).select(bean(MeasurerVO.class,
                        measurerEntity.measurerId.as("measurerId"),
                        measurerEntity.measurermeterm3.as("measurermeterm3")))
                .where(measurerEntity.measurerId.eq(id)).fetchOne();
    }
}
