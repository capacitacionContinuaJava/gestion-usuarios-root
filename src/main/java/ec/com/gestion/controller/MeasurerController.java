package ec.com.gestion.controller;

import ec.com.gestion.service.IMeasurerService;
import ec.com.gestion.vo.MeasurerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to management measurer web services.
 */
@RequestMapping("api/public/measurer")
public class MeasurerController {

    @Autowired
    private IMeasurerService measurerService;

    /**
     * Service to find measurer by id.
     * @param id
     * @return
     */
    @GetMapping("/findBy/{id}")
    public ResponseEntity<MeasurerVO> findById (@PathVariable("id") long id){
        try{
            MeasurerVO measurerVo = this.measurerService.findByMeasurerId(id);
            return new ResponseEntity<>(measurerVo, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>( null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Service to find all measurer.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<MeasurerVO>> findAll (){
        try {
            List<MeasurerVO>  measurerLst = this.measurerService.findAll();
            return new ResponseEntity<>(measurerLst, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Service to create  measurer
     * @param  measurerVO
     * @return
     */
    @PostMapping ("/createMeasurer")
    public ResponseEntity<MeasurerVO> createMeasurer(@RequestBody MeasurerVO measurerVO){
        try {
            this.measurerService.createMeasurer(measurerVO);
            return new ResponseEntity <> (measurerVO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity <>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
