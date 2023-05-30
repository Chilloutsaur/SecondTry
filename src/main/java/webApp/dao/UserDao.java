package webApp.dao;

import webApp.model.User;
import webApp.service.UserService;

import java.util.List;


public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);


    void addUser(User user);
}
