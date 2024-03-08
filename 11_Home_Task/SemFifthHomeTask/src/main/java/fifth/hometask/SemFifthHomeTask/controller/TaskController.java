package fifth.hometask.SemFifthHomeTask.controller;

import fifth.hometask.SemFifthHomeTask.domain.Task;
import fifth.hometask.SemFifthHomeTask.service.TasksService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    TasksService tasksService;


    /**
     * Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
     **/
    @GetMapping()
    public List<Task> findAll(){
        return tasksService.findAll();
    }

    /**
     * Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
     * Подсказка метод в контроллере: @GetMapping("/status/{status}")
     * public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
     * Список статусов которые необходимо передавать @PathVariable, чтобы получить список по status:
     *  - начать;
     *  - в процессе;
     *  - задача завершена;
     */

    @GetMapping("/{status}")
    public List<Task> getTaskByStatus(@PathVariable String status){
        return tasksService.getTaskByStatus(status);
    }

    /**
     * Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
     */
    @PostMapping()
    public Task addTask(@RequestBody Task task){
        tasksService.addTask(task);
        return task;
    }

    /**
     * Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}")
     * public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
     */

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        tasksService.addTask(task);
        return task;
    }

    /**
     * Удаление задачи. Подсказка метод в контроллере: @DeleteMapping("/{id}")
     * public void deleteTask(@PathVariable Long id)
     */

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        tasksService.deleteTask(id);
    }


}
