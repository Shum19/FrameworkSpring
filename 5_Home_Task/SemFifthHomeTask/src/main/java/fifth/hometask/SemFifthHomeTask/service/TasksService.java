package fifth.hometask.SemFifthHomeTask.service;

import fifth.hometask.SemFifthHomeTask.domain.Task;
import fifth.hometask.SemFifthHomeTask.repositories.TasksRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TasksService {
    private TasksRepo tasksRepo;

    public List<Task> findAll(){
        return tasksRepo.findAll();
    }
//    @Query(value = "SELECT * FROM tasksTABLE WHERE status=?")
    public List<Task> getTaskByStatus(String status){
        return tasksRepo.getTaskByStatus(status);
    }
    public void addTask(Task task){
        tasksRepo.save(task);
    }
    public void deleteTask(Long id){
        tasksRepo.deleteById(id);
    }


}
