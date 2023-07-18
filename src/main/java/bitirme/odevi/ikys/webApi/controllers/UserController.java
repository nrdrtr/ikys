package bitirme.odevi.ikys.webApi.controllers;

import bitirme.odevi.ikys.dataAccess.abstracts.UserDao;
import bitirme.odevi.ikys.entitites.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserDao userDao;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.userDao.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(User user){
        return ResponseEntity.ok(this.userDao.save(user));
    }
}
