package hw.springWeb.domain;

import lombok.*;
import org.springframework.stereotype.Component;


@Data
@EqualsAndHashCode
@Component
public class User {

    int id;
    private String name;
    private int age;
    private String email;

}
