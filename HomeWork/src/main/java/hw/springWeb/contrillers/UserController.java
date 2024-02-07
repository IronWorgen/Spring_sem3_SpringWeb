package hw.springWeb.contrillers;

import hw.springWeb.domain.User;
import hw.springWeb.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getUserRepository().add(user);
        return "User added from body!";
    }

    @PostMapping("/add")
    public void userAddFromParam(
            @RequestParam(value = "username") String name,
            @RequestParam(value = "age") int age,
            String email) {
        service.processRegistration(name, age, email);
    }
}

