package third.hometask.SemThirdHomeTask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import third.hometask.SemThirdHomeTask.domain.User;
import third.hometask.SemThirdHomeTask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    DataProcessingService dataProcessingService;
    @GetMapping
    public List<String> getAllTask(){
        List <String> task = new ArrayList<>();
        task.add("Sort");
        task.add("Filter by Age");
        task.add("Show average age");
        return task;
    }
    @GetMapping("/sort")
    public List<User> sortUsersByAge(){

//        Метод использует обычный список из Class UserRepository
//        return dataProcessingService.sortUserByAge(dataProcessingService.getRepository().getUserList());

//        Метод использует Class  UserRepo на H2
        return dataProcessingService.sortUserByAge(dataProcessingService.getRepo());
    }
    //метод filterUsersByAge
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAge(@PathVariable int age){

//        Метод использует обычный список из Class UserRepository
//        return dataProcessingService.filterUserByAge(dataProcessingService.getRepository().getUserList(),age);

//        Метод использует Class  UserRepo на H2
        return dataProcessingService.filterUserByAge(dataProcessingService.getRepo(), age);
    }

    //метод calculateAverageAge
    @GetMapping("/calc")
    public double averageAge(){

//        Метод использует обычный список из Class UserRepository
//        double average = dataProcessingService.calculateAverage(dataProcessingService.getRepository().getUserList());

//        Метод использует Class  UserRepo на H2
        double average = dataProcessingService.calculateAverage(dataProcessingService.getRepo());
        return average;
    }

}
