package seventh.hometask.authorizationserver.SemSeventhHomeTask.UserRepo;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seventh.hometask.authorizationserver.SemSeventhHomeTask.domain.MyUser;

@Repository
public interface UserRepo  extends JpaRepository<MyUser, Long> {
    MyUser findByName(String name);
}
