package ec.com.gestion.controller;

import ec.com.gestion.service.ICompanyService;
import ec.com.gestion.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to management company web services.
 */
@RestController
@RequestMapping("api/public/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    /**
     * Service to find company by id.
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<CompanyVO> findById(@PathVariable("id") Long id){
        try {
            CompanyVO companyVo = this.companyService.findByCompanyId(id);
            return new ResponseEntity<>(companyVo, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find all companies.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<CompanyVO>> findAll(){
        try {
            List<CompanyVO> companyLst = this.companyService.findAll();
            return new ResponseEntity<>(companyLst, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to create company
     * @param companyVO
     * @return
     */
    @PostMapping("/createCompany")
    public ResponseEntity<CompanyVO> createCompany(@RequestBody CompanyVO companyVO){
        try {
            this.companyService.createCompany(companyVO);
            return new ResponseEntity<>(companyVO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
