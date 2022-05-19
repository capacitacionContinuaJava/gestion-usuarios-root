package ec.com.gestion.controller;

import ec.com.gestion.service.IEmpresaService;
import ec.com.gestion.vo.EmpresaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to management empresa web services.
 */
@RestController
@RequestMapping("api/public/empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaService empresaService;

    /**
     * Service to find empresa by id.
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<EmpresaVO> findById(@PathVariable("id") Long id){
        try {
            EmpresaVO empresaVo = this.empresaService.findByEmpresaId(id);
            return new ResponseEntity<>(empresaVo, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find all empresas.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<EmpresaVO>> findAll(){
        try {
            List<EmpresaVO> empresaLst = this.empresaService.findAll();
            return new ResponseEntity<>(empresaLst, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to create empresa
     * @param empresaVO
     * @return
     */
    @PostMapping("/createEmpresa")
    public ResponseEntity<EmpresaVO> createEmpresa(@RequestBody EmpresaVO empresaVO){
        try {
            this.empresaService.createEmpresa(empresaVO);
            return new ResponseEntity<>(empresaVO, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
