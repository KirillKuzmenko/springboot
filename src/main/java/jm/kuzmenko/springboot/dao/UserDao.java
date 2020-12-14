package jm.kuzmenko.springboot.dao;

import jm.kuzmenko.springboot.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    List<User> listUser();
    User getUserById(Long id);
    void removeUser(Long id);
    User findUserByUsername(String username);
}
