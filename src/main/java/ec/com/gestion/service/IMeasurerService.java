package ec.com.gestion.service;

import ec.com.gestion.vo.MeasurerVO;

import java.util.List;

/**
 * Interface to management measurer service methods.
 */

public interface IMeasurerService {

    /**
     * Method to find measurer list
     * @return
     */
    List<MeasurerVO> findAll();

    /**
     * Method to find measurer by id.
     * @param id
     * @return
     */
    MeasurerVO findByMeasurerId(Long id);

    /**
     * Method to create empresa.
     * @param measurerVO
     */
    void createMeasurer(MeasurerVO measurerVO);
}
