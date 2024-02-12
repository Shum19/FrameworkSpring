package third.hometask.SemThirdHomeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import third.hometask.SemThirdHomeTask.domain.User;
import third.hometask.SemThirdHomeTask.repositories.UserRepository;
import third.hometask.SemThirdHomeTask.repositories.UserRepo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
//    Repository H2
    @Autowired
    UserRepo repo;
    @Autowired
    UserRepository userRepository;

    // или конструктор

//    public DataProcessingService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<User> sortUserByAge(List<User> userList){
        return userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }

    public List<User> filterUserByAge(List<User> userList, int age){
        return userList.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }
    public double calculateAverage(List<User> userList){
        return userList.stream().mapToInt(User :: getAge).average().orElse(0);
    }
//    Методы для  Class UserRepository
    public void addUserToList(User user){
        userRepository.getUserList().add(user);
    }

    public UserRepository getRepository() {
        return userRepository;
    }

//    Методы для  Class UserRepo
    /**
     *  Метод вносит пользователя в базу данных H2
     * @param user
     */
    public void addUserToRepo(User user){
        repo.save(user);
    }

    /**
     *
     * @return Возвращает список пользователей из базы данных
     */
    public List <User> getRepo(){
        return repo.getAllUsers();
    }
}
