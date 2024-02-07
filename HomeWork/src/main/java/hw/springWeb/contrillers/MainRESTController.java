package hw.springWeb.contrillers;

import hw.springWeb.domain.User;
import hw.springWeb.services.DataProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class MainRESTController {

    private final DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }

    //метод filterUsersByAge
    //Подсказка  @GetMapping("/filter/{age}")
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);
    }


    //метод calculateAverageAge
    //Подсказка  @GetMapping("/calc")
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }
}
