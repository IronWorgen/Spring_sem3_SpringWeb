package hw.springWeb.repository;

import hw.springWeb.domain.User;

import java.util.List;

public interface iUserRepository {
    /**
     * получить список всех пользователей
     *
     * @return список пользователей из репозитория
     */
    List<User> getUsers();


    /**
     * добавление пользователя в репозиторий
     *
     * @param user пользователь для добавления
     */
    void add(User user);
}
