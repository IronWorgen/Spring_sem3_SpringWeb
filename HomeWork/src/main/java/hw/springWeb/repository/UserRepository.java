package hw.springWeb.repository;

import hw.springWeb.domain.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("list")
@Getter
public class UserRepository implements iUserRepository {
    private final List<User> users = new ArrayList<>();

    @Override
    public void add(User user) {
        users.add(user);
    }
}
