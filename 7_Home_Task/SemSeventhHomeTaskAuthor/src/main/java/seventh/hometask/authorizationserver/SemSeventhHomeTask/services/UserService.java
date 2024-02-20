package seventh.hometask.authorizationserver.SemSeventhHomeTask.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seventh.hometask.authorizationserver.SemSeventhHomeTask.domain.MyUser;
import seventh.hometask.authorizationserver.SemSeventhHomeTask.UserRepo.UserRepo;

import java.util.List;

@Service

public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<MyUser> findAll(){
        return userRepo.findAll();
    }
    public MyUser findByName(String name){
        return userRepo.findByName(name);
    }

}
