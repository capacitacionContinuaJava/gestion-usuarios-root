package ec.com.gestion.controller;

import ec.com.gestion.service.IEmployeeService;
import ec.com.gestion.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to management employee web services.
 */
@RestController
@RequestMapping("api/public/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    /**
     * Service to find employee by id.
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<EmployeeVO> findById(@PathVariable("id") Long id){
        try {
            EmployeeVO employeeVO = this.employeeService.findByEmployeeId(id);
            return new ResponseEntity<>(employeeVO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find all employees.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeVO>> findAll(){
        try {
            List<EmployeeVO>  employeeLst = this.employeeService.findAll();
            return new ResponseEntity<>(employeeLst, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to create employee.
     * @param employeeVO
     * @return
     */
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeVO> createEmployee(@RequestBody EmployeeVO employeeVO){
        try {
            this.employeeService.createEmployee(employeeVO);
            return new ResponseEntity<>(employeeVO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
