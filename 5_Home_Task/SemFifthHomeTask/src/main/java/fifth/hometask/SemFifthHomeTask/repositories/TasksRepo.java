package fifth.hometask.SemFifthHomeTask.repositories;

import fifth.hometask.SemFifthHomeTask.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepo extends JpaRepository<Task, Long> {

    List<Task> getTaskByStatus(String status);


}
