package third.hometask.SemThirdHomeTask.repositories;

import org.springframework.stereotype.Repository;
import third.hometask.SemThirdHomeTask.domain.User;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
    private List<User> userList;

    public UserRepository(){
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
