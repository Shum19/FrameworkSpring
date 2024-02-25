package eights.hometask.resourceserver.SemEightsHomeTask.services;

import eights.hometask.resourceserver.SemEightsHomeTask.aspects.TrackUserActionAnnotation;
import eights.hometask.resourceserver.SemEightsHomeTask.domain.MyUser;
import eights.hometask.resourceserver.SemEightsHomeTask.repositories.MyUserRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServices {
    MyUserRepo userRepo;

    public MyUserServices(MyUserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @TrackUserActionAnnotation
    public List<MyUser> findAll(){
       return userRepo.findAll();
    }
    public MyUser findByName(String name){
        return userRepo.findByName(name);
    }
    @TrackUserActionAnnotation
    public MyUser saveUser(MyUser myUser){
        return userRepo.save(myUser);
    }

}
