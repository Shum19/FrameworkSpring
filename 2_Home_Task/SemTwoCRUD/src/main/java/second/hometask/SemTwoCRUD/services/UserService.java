package second.hometask.SemTwoCRUD.services;

import org.springframework.stereotype.Service;
import second.hometask.SemTwoCRUD.model.User;
import second.hometask.SemTwoCRUD.reposytories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteByID(int id){
        userRepository.deleteById(id);
    }
    public User updateUser(User user){
        return userRepository.updateById(user);
    }
}
