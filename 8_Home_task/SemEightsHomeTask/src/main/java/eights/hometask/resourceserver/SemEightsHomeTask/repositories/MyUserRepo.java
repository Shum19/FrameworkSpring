package eights.hometask.resourceserver.SemEightsHomeTask.repositories;

import eights.hometask.resourceserver.SemEightsHomeTask.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Long> {
    MyUser findByName(String name);

}
