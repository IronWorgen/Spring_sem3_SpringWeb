package hw.springWeb.services;

import hw.springWeb.domain.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final DataProcessingService dataProcessingService;
    private final UserService userService;
    private final NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    //Поля UserService, NotificationService
    //Метод processRegistration
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification(
                String.format("Пользователь '%s'(%d,%s) - добавлен", name, age, email));
    }

}
