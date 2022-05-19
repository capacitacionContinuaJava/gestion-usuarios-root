package ec.com.gestion.controller;

import ec.com.gestion.service.IClientService;
import ec.com.gestion.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller to management client web service.
 */
@RestController
@RequestMapping("api/public/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    /**
     * Service to find client by id.
     *
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<ClientVO> findById(@PathVariable("id") Long id) {
        try {
            ClientVO clientVo = this.clientService.findByClientId(id);
            return new ResponseEntity<>(clientVo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find all client.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<ClientVO>> findAll(){
        try{
            List<ClientVO> clientLst = this.clientService.findAll();
            return new ResponseEntity<>(clientLst,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service ti create client
     * @param clientVO
     * @return
     */
    @PostMapping("/createClient")
    public ResponseEntity<ClientVO> createClient(@RequestBody ClientVO clientVO){
        try {
            this.clientService.createClient(clientVO);
            return new ResponseEntity<>(clientVO,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
