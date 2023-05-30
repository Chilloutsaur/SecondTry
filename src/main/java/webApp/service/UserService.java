package webApp.service;

import webApp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

    void addUser(User user);
}
