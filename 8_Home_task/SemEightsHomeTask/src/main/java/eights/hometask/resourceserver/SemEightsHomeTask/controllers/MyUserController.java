package eights.hometask.resourceserver.SemEightsHomeTask.controllers;

import eights.hometask.resourceserver.SemEightsHomeTask.domain.MyUser;
import eights.hometask.resourceserver.SemEightsHomeTask.services.MyUserServices;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MyUserController {
    MyUserServices myUserServices;

    public MyUserController(MyUserServices myUserServices) {
        this.myUserServices = myUserServices;
    }

    @GetMapping
    public List<MyUser> findAll(){
        return myUserServices.findAll();
    }
    @PostMapping
    public void saveUser(@RequestBody MyUser myUser){
        myUserServices.saveUser(myUser);
    }
}
