package seventh.hometask.authorizationserver.SemSeventhHomeTask.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import seventh.hometask.authorizationserver.SemSeventhHomeTask.UserRepo.UserRepo;
import seventh.hometask.authorizationserver.SemSeventhHomeTask.domain.MyUser;
import seventh.hometask.authorizationserver.SemSeventhHomeTask.services.UserService;

import java.util.List;

//@Data
//@Controller
//@RestController
//public class RestContr {
//    @Autowired
//    UserService userService;
//    @GetMapping
//    public List<MyUser> findAll(){
//        return userService.findAll();
//    }
//
//
//}
