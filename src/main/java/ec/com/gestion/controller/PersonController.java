package ec.com.gestion.controller;

import ec.com.gestion.service.IPersonService;
import ec.com.gestion.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to management person web services.
 */
@RestController
@RequestMapping("api/public/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    /**
     * Service to find person by id.
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable("id") Long id){
        try {
            PersonVO personVO = this.personService.findByPersonId(id);
            return new ResponseEntity<>(personVO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find all persons.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<PersonVO>> findAll(){
        try {
            List<PersonVO> personLst = this.personService.findAll();
            return new ResponseEntity<>(personLst, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to create person.
     * @param personVO
     * @return
     */
    @PostMapping("/createPerson")
    public ResponseEntity<PersonVO> createPerson(@RequestBody PersonVO personVO){
        try {
            this.personService.createPerson(personVO);
            return new ResponseEntity<>(personVO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
