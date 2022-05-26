package ec.com.gestion.repository;

import ec.com.gestion.entity.MeasurerEntity;
import ec.com.gestion.vo.MeasurerVO;

import java.util.List;
/**
 * Interface to management measurer repository.
 */

public interface IMeasurerRepository extends IQueryDslRepository<MeasurerEntity> {

    /**
     * Method to find measurer list.
     */

    List<MeasurerVO> findAll();

    /**
     * Find user by id.
     * @param id
     * @return
     */
    MeasurerVO findByMeasurerId(Long id);


}
