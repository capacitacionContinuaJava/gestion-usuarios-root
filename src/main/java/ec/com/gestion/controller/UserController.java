package ec.com.gestion.controller;

import ec.com.gestion.service.IUserService;
import ec.com.gestion.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to management user web services.
 */
@RestController
@RequestMapping("api/public/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * Service to find user by id.
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserVO> findById(@PathVariable("id") Long id){
        try {
            UserVO userVo = this.userService.findByUserId(id);
            return new ResponseEntity<>(userVo, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find user by user name.
     * @param userName
     * @return
     */
    @GetMapping("/findByUserName/{userName}")
    public ResponseEntity<UserVO> findById(@PathVariable("userName") String userName){
        try {
            UserVO userVo = this.userService.findByUserName(userName);
            return new ResponseEntity<>(userVo, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to login user.
     * @param userVO
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserVO userVO){
        try {
            return new ResponseEntity<>(this.userService.login(userVO), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to find all users.
     * @return
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<UserVO>> findAll(){
        try {
            List<UserVO> userLst = this.userService.findAll();
            return new ResponseEntity<>(userLst, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Service to create user.
     * @param userVO
     * @return
     */
    @PostMapping("/createUser")
    public ResponseEntity<UserVO> createUser(@RequestBody UserVO userVO){
        try {
            this.userService.createUser(userVO);
            return new ResponseEntity<>(userVO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
