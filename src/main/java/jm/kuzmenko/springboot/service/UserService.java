package jm.kuzmenko.springboot.service;

import jm.kuzmenko.springboot.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    List<User> listUser();
    User getUserById(Long id);
    void removeUser(Long id);
    User findUserBuyUsername(String username);
}
